package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Các phương thức đặc thù cho bảng Account (nếu cần)
    @Query("SELECT a FROM Account a where a.username = :username")
    public Account findByUsername(@Param("username") String username);

}
