package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Các phương thức đặc thù cho bảng Account (nếu cần)
    @Query("SELECT o FROM Account o WHERE o.username = :username")
    Account findByUsername(String username);

    @Query("SELECT o FROM Account o WHERE o.email = :email")
    Account findByEmail(String email);

    Account save(AccountDTO account);
}
