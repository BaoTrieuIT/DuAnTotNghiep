package com.poly.website_norulesshop.config;

import com.poly.website_norulesshop.collection.MyAccountDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        MyAccountDetails myAccountDetails = (MyAccountDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = myAccountDetails.getAuthorities();
        authorities.forEach(auth -> System.out.println(auth.getAuthority()));
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
