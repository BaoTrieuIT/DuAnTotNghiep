package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.DirectoryLv2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryLv2Repository extends JpaRepository<DirectoryLv2, Long> {
    // Các phương thức đặc thù cho bảng DirectoryLv2 (nếu cần)
}
