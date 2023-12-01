package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderDetail;
import com.poly.website_norulesshop.entity.OrderStatus;
import com.poly.website_norulesshop.entity.PaymentMethod;
import com.poly.website_norulesshop.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("home")
public class CheckOutController {
    @Autowired
    PaymentMethodService paymentMethodService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderStatusService orderStatusService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    GeneralService generalService;

    @GetMapping("checkout-page")
    public String index(Model model, HttpSession session) {

        List<PaymentMethod> paymentMethodList = paymentMethodService.getAllPaymentMethods();
        model.addAttribute("paymentMethod", paymentMethodList);
        model.addAttribute("acc", session.getAttribute("acc"));
        model.addAttribute("title", "Thanh toán đơn hàng");

        return "user/checkout_page";
    }

    @GetMapping("order-confirm/{orderId}")
    public String orderConfrim(Model model, @PathVariable("orderId") Integer id) {
        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetail = orderDetailService.findByOrderId(order.getOrderId());

        model.addAttribute("order", order);
        model.addAttribute("orderDetail", orderDetail);

        model.addAttribute("title", "Xác nhận đơn hàng");
        return "user/order_confirm";
    }

    @GetMapping("order-history")
    public String orderHistory(Model model, Principal principal) {
        Integer accountId = generalService.usernameHandler(principal);
        List<Order> orderList = orderService.findByUserId(accountId);
        model.addAttribute("orderList", orderList);
        orderList.sort(Comparator.comparing(Order::getOrderTime).reversed());
        model.addAttribute("title", "Lịch sử đặt hàng");
        return "user/order_history";
    }

    @PostMapping("/order-update/{orderId}")
    public String updateCancelOrder(@PathVariable Integer orderId) {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(1);
        System.out.println("orderStatus" + orderStatus.getOrderStatusId());
        Order order = orderService.getOrderById(orderId);
        System.out.println("order" + order.getOrderStatus().getOrderStatusId());
        order.setOrderStatus(orderStatus);
        orderService.saveOrder(order);
        return "redirect:/home/order-history";
    }
}
