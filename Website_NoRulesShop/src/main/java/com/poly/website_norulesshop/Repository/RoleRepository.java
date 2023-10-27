package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Các phương thức đặc thù cho bảng Role (nếu cần)
}
