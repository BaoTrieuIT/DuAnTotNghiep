package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.DirectoryLv1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryLv1Repository extends JpaRepository<DirectoryLv1, Long> {
    // Các phương thức đặc thù cho bảng DirectoryLv1 (nếu cần)
}
