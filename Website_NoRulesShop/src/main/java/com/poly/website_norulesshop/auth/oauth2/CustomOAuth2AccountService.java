package com.poly.website_norulesshop.auth.oauth2;

import com.poly.website_norulesshop.Repository.RoleRepository;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Role;
import com.poly.website_norulesshop.service.AccountService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CustomOAuth2AccountService extends DefaultOAuth2UserService {

    private final RoleRepository roleRepository;
    private final AccountService accountService;

    public CustomOAuth2AccountService(RoleRepository roleRepository, AccountService accountService) {
        this.roleRepository = roleRepository;
        this.accountService = accountService;
    }


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String clientName = userRequest.getClientRegistration().getClientName();
        OAuth2User user = super.loadUser(userRequest);
        // Mở rộng yêu cầu để lấy thông tin vai trò từ OAuth2 provider
        Set<Role> roles = getRolesFromOAuth2Provider(user);
        Account existingAccount = getUsernameFromOAuth2(user);
        return new CustomOauth2Account(user, roles, clientName, existingAccount);
    }

    private Set<Role> getRolesFromOAuth2Provider(OAuth2User oAuth2User) {
        // Trong ví dụ này, giả sử vai trò được lấy từ thuộc tính "roles" của OAuth2 provider.
        List<String> roleNames = oAuth2User.getAttribute("roles");

        if (roleNames != null) {
            // Chuyển đổi các tên vai trò thành đối tượng Role
            return roleNames.stream()
                    .map(roleName -> {
                        Role role = new Role();
                        role.setRole_name(roleName);
                        return role;
                    })
                    .collect(Collectors.toSet());
        } else {
            // Nếu không có thông tin vai trò, có thể trả về vai trò mặc định hoặc xử lý theo ý muốn của bạn.
            // Ví dụ: Trả về vai trò "USER" nếu không có thông tin vai trò.
            Role defaultRole = roleRepository.findRoleByRole_name("USER");
            return Collections.singleton(defaultRole);
        }
    }

    private Account getUsernameFromOAuth2(OAuth2User oAuth2User) {
        String existingEmail = oAuth2User.getAttribute("email");
        return accountService.findByEmail(existingEmail);
    }
}
