package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("home")
public class CheckOutController {
    @Autowired
    PaymentMethodService paymentMethodService;
    @Autowired
    OrderService orderService;
    @Autowired
    CategoryQuantityService categoryQuantityService;
    @Autowired
    ProductService productService;
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
    public String orderConfirm(Model model, @PathVariable("orderId") Integer id) {
        Order order = orderService.getOrderById(id);
        List<OrderDetail> orderDetail = orderDetailService.findByOrderId(id);
        model.addAttribute("order", order);
        model.addAttribute("orderDetail", orderDetail);
        model.addAttribute("title", "Xác nhận đơn hàng");
        return "user/order_confirm";
    }

    @GetMapping("order-result")
    public String orderConfirmByVnPay(Model model,
                                      @RequestParam("orderId") Integer id,
                                      @RequestParam("vnp_Amount") String vnp_Amount,
                                      @RequestParam("vnp_TxnRef") String vnp_TxnRef,
                                      @RequestParam("vnp_OrderInfo") String vnp_OrderInfo,
                                      @RequestParam("vnp_PayDate") String vnp_PayDate,
                                      @RequestParam("vnp_TransactionStatus") String vnp_TransactionStatus) {
        if (vnp_TransactionStatus.equalsIgnoreCase("00")) {
            System.out.println("Run this");
            Order order = orderService.getOrderById(id);
            List<OrderDetail> orderDetail = orderDetailService.findByOrderId(order.getOrderId());
            model.addAttribute("order", order);
            model.addAttribute("orderDetail", orderDetail);
            model.addAttribute("title", "Xác nhận đơn hàng");
        } else {
            orderDetailService.deleteOrderId(id);
            orderService.deleteById(id);
            return "redirect:/home/checkout-page";
        }
        return "user/order_confirm";

    }

    @GetMapping("order-history")
    public String orderHistory(Model model, Principal principal) {
        Integer accountId = generalService.usernameHandler(principal);
        System.out.println(accountId);
        try {
            List<Order> orderList = orderService.findByUserId(accountId);
            model.addAttribute("orderList", orderList);
            orderList.sort(Comparator.comparing(Order::getOrderTime).reversed());
            model.addAttribute("title", "Lịch sử đặt hàng");
            return "user/order_history";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "user/order_history";
    }

    @PostMapping("/order-update/{orderId}")
    public String updateCancelOrder(@PathVariable Integer orderId) {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(5);
        Order order = orderService.getOrderById(orderId);
        List<OrderDetail> orderDetailList = orderDetailService.findByOrderId(orderId);
        for (OrderDetail orderDetail : orderDetailList) {
            Product product = orderDetail.getProduct();
            CategoryQuantity categoryQuantity = orderDetail.getCategoryQuantity();
            int quantityOfOrder = orderDetail.getQuantity();
            int currentQtyOfProduct = product.getTotalQuantity();
            int quantityOfCategory = categoryQuantity.getQuantity();
            int updateQtyOfProduct = Math.max(0, currentQtyOfProduct + quantityOfOrder);
            int updateQtyOfCategory = Math.max(0, quantityOfCategory + quantityOfOrder);
            product.setTotalQuantity(updateQtyOfProduct);
            categoryQuantity.setQuantity(updateQtyOfCategory);
            categoryQuantityService.saveCategoryQuantity(categoryQuantity);
            productService.saveProduct(product);
        }
        order.setOrderStatus(orderStatus);
        order.setOrderUpdateTime(new Date());
        orderService.saveOrder(order);
        return "redirect:/home/order-history";
    }
}
