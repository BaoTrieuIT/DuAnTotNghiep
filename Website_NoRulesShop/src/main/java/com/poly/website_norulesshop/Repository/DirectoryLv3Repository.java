package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.DirectoryLv3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryLv3Repository extends JpaRepository<DirectoryLv3, Long> {
    // Các phương thức đặc thù cho bảng DirectoryLv3 (nếu cần)
}
