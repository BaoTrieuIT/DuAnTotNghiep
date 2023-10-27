package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Voucher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VoucherService {
    Voucher saveVoucher(Voucher voucher);

    Voucher getVoucherById(Long id);

    List<Voucher> getAllVouchers();

    void deleteVoucher(Long id);
}
