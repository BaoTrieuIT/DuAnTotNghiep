package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Các phương thức đặc thù cho bảng Address (nếu cần)

    Optional<Address> findAddressByAccount(Account account);
}
