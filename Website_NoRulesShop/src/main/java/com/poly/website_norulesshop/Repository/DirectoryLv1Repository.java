package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryLv1Repository extends JpaRepository<DirectoryLv1, Integer> {
    // Các phương thức đặc thù cho bảng DirectoryLv1 (nếu cần)
    List<DirectoryLv1> findByDirectory(Directory directory);

}
