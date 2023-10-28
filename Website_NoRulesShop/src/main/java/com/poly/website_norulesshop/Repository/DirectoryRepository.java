package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Integer> {
//    @Query("insert into directory values ())
    // Các phương thức đặc thù cho bảng Directory (nếu cần)
    List<Directory> findByGender(Gender gender);
}
