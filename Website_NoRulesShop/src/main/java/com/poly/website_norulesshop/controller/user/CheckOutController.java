package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.PaymentMethod;
import com.poly.website_norulesshop.service.PaymentMethodService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("home")
public class CheckOutController {
    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping("checkout-page")
    public String index(Model model, HttpSession session) {

        List<PaymentMethod> paymentMethodList = paymentMethodService.getAllPaymentMethods();
        model.addAttribute("paymentMethod", paymentMethodList);
        model.addAttribute("acc", session.getAttribute("acc"));

        return "user/checkout_page";
    }

    @GetMapping("order-confirm")
    public String orderConfrim(Model model) {
        return "user/order_confirm";
    }
}
