package com.poly.website_norulesshop.config;

import com.poly.website_norulesshop.auth.oauth2.CustomOAuth2AccountService;
import com.poly.website_norulesshop.auth.oauth2.CustomOauth2Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.Impl.AccountDetailsServiceImpl;

import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private CustomOAuth2AccountService customOAuth2AccountService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpSession session;


    private static final String[] USER_RESOURCES = {
            "/home/checkout-page/**",
            "/home/my-account/**",
            "/home/order-confirm/**",
            "/home/order-history/**"
    };
    private static final String[] ADMIN_RESOURCES = {
            "/admin/**"
    };


    @Bean
    public UserDetailsService userDetailsService() {
        return new AccountDetailsServiceImpl();
    }


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, RememberMeServices rememberMeServices) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(ADMIN_RESOURCES).hasAuthority("Admin")
                        .requestMatchers(USER_RESOURCES).authenticated()
                        .anyRequest().permitAll())
                .formLogin(login -> login.loginPage("/home/sign-in")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler((request, response, authentication) -> {
                            String username = authentication.getName();
                            Account acc = accountService.findByUsername(username);
                            session.setAttribute("authentication", authentication);
                            session.setAttribute("acc", acc);
                            response.sendRedirect("/");
                        })

//                        .failureUrl("/home/sign-in")
                        .failureHandler((request, response, exception) -> response
                                .sendRedirect("/home/sign-in?error"))
                        .permitAll())
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID")
                        .logoutUrl("/home/sign-out")
                        .permitAll())
                .rememberMe((remember) -> remember
                        .rememberMeServices(rememberMeServices).tokenValiditySeconds(86400).rememberMeParameter("remember_me"))
                .exceptionHandling(execpetion -> execpetion
                        .accessDeniedPage("/home/403Page")
                        .accessDeniedHandler(((request, response, accessDeniedException) -> response
                                .sendRedirect("/home/403Page"))))
                .oauth2Login(oauth2 -> {
                    try {
                        oauth2.loginPage("/home/sign-in").authorizationEndpoint((authorization ->
                                        authorization
                                                .baseUri("/home/sign-in/oauth2/authorization")
                                                .baseUri("/oauth2/authorization")))
                                .userInfoEndpoint(userInfo -> userInfo
                                        .userService(customOAuth2AccountService))
                                .successHandler((request, response, authentication) -> {
                                    if (authentication.getPrincipal() instanceof CustomOauth2Account customOauth2Account) {
                                        String email = customOauth2Account.getName();
                                        Account existingUser = accountService.findByEmail(email);
                                        if (existingUser != null) {
                                            if (existingUser.getAccountStatus().getAccountStatusId() == 1) {
                                                session.setAttribute("authentication", authentication);
                                                session.setAttribute("acc", existingUser);
                                                GlobalFlag.flag = true;
                                                response.sendRedirect("/");
                                            } else {
                                                GlobalFlag.flag = false;
                                                response.sendRedirect("/home/sign-in?error");
                                            }
                                        } else {
                                            String username = customOauth2Account.getUsername();
                                            String clientName = customOauth2Account.getOauth2ClientNames();
                                            accountService.processOAuthPostLogin(email, clientName);
                                            session.setAttribute("authentication", authentication);
                                            session.setAttribute("acc", existingUser);
                                            response.sendRedirect("/");
                                        }
                                    } else {
                                        // Handle other cases if needed
                                        response.sendRedirect("/home/sign-in"); // Redirect to login page in case of an issue
                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        return http.build();
    }

    @Bean
    RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm = TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
        TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("3434344efterf", userDetailsService, encodingAlgorithm);
        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.MD5);
        return rememberMe;
    }


}
