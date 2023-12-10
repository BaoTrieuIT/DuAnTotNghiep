package com.poly.website_norulesshop.auth.oauth2;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomOauth2Account implements OAuth2User {

    private final Set<Role> roles;
    private final OAuth2User oAuth2User;
    @Getter
    private final String oauth2ClientNames;
    private final Account account;

    public CustomOauth2Account(OAuth2User oAuth2User, Set<Role> roles, String oauth2ClientNames, Account account) {
        this.oAuth2User = oAuth2User;
        this.roles = roles;
        this.oauth2ClientNames = oauth2ClientNames;
        this.account = account;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return mapRolesToAuthorities(roles);
    }


    @Override
    public String getName() {
        return oAuth2User.getAttribute("email");
    }

    public String getUsername() {
        return (account != null) ? account.getUsername() : oAuth2User.getAttribute("email");
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
