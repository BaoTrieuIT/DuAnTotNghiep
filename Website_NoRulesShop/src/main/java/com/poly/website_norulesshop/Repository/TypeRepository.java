
package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    // Các phương thức truy vấn cụ thể nếu cần
}
