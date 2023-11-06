package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Các phương thức đặc thù cho bảng Role (nếu cần)

    @Query("SELECT o FROM Role o where o.role_name = :role_name")
    Role findRoleByRole_name(String role_name);
}
