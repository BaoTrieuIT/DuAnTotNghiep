package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.Voucher;
@Service
public interface VoucherService {
    Voucher saveVoucher(Voucher voucher);

    Voucher getVoucherById(Integer id);

    List<Voucher> getAllVouchers();

    void deleteVoucher(Integer id);
}
