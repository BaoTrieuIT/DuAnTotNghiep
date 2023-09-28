//package com.poly.website_norulesshop.config;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
//
//public class SecurityConfig extends WebSecurityConfigurationAdapter {
//    // Cho phép truy xuất REST API từ domain khác
//
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().ant(HttpMethod.OPTIONS, "/**");
//    }
//}
