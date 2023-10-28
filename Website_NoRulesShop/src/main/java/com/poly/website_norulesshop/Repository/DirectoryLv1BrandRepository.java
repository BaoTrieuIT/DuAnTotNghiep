package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.DirectoryLv1Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryLv1BrandRepository extends JpaRepository<DirectoryLv1Brand, Integer> {
}
