package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    Role saveRole(Role role);

    Role getRoleById(Integer id);

    List<Role> getAllRoles();

    void deleteRole(Integer id);
}