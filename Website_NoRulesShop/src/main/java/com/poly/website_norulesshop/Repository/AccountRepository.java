package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Các phương thức đặc thù cho bảng Account (nếu cần)
    @Query("SELECT o FROM Account o WHERE o.username = :username")
    Account findByUsername(String username);

    @Query("SELECT o FROM Account o WHERE o.email = :email")
    Account findByEmail(String email);

    Account save(AccountDTO account);

    @Query("SELECT COUNT(DISTINCT a) FROM Account a " +
            "JOIN a.roles r " +
            "WHERE r.role_name = 'USER' " +
            "AND a.create_date = CURRENT_DATE")
    Integer countUsersByRoleAndToday();

    @Query("SELECT COUNT(DISTINCT a) FROM Account a " +
            "JOIN a.roles r " +
            "WHERE r.role_name = 'USER' " +
            "AND YEAR(a.create_date) = YEAR(CURRENT_DATE) ")
    Integer countUsersByRoleAndYear();

    @Query("SELECT COUNT(DISTINCT a) FROM Account a " +
            "JOIN a.roles r " +
            "WHERE r.role_name = 'USER' " +
            "AND MONTH(a.create_date) = MONTH(CURRENT_DATE) ")
    Integer countUsersByRoleAndMonth();
}
