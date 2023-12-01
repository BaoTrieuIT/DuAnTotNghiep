//package com.poly.website_norulesshop.controller.user;
//
//
//import com.poly.website_norulesshop.config.VNPayConfig;
//import com.poly.website_norulesshop.entity.Order;
//import com.poly.website_norulesshop.service.AccountService;
//import com.poly.website_norulesshop.service.GeneralService;
//import com.poly.website_norulesshop.service.OrderService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.security.Principal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@Controller
//@CrossOrigin("*")
//public class PaymentController {
//    AccountService accountService;
//    OrderService orderService;
//    //    PaymentService paymentService;
//    GeneralService generalService;
//
//    public PaymentController(AccountService accountService, OrderService orderService, GeneralService generalService) {
//        this.accountService = accountService;
//        this.orderService = orderService;
//        this.generalService = generalService;
//    }
//
//
//    @GetMapping("/pay")
//    public String getPay(Principal principal) {
//        Integer userId = generalService.usernameHandler(principal);
////        BigDecimal total = cartService.getTotalPriceByUserId(userId);
//        System.out.println(total);
//        String vnp_Version = "2.1.0";
//        String vnp_Command = "pay";
//        String orderType = "other";
//        long amount = total.multiply(BigDecimal.valueOf(100)).longValue();
//        String bankCode = "NCB";
//        String vnp_TxnRef = "NR" + VNPayConfig.getRandomNumber(8);
//        String vnp_IpAddr = "127.0.0.1";
//
//        String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
//
//        Map<String, String> vnp_Params = new HashMap<>();
//        vnp_Params.put("vnp_Version", vnp_Version);
//        vnp_Params.put("vnp_Command", vnp_Command);
//        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
//        vnp_Params.put("vnp_Amount", String.valueOf(amount));
//        vnp_Params.put("vnp_CurrCode", "VND");
//
//        vnp_Params.put("vnp_BankCode", bankCode);
//        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
//        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
//        vnp_Params.put("vnp_OrderType", orderType);
//        vnp_Params.put("vnp_Locale", "vn");
//        vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
//        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
//
//        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String vnp_CreateDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
//
//        cld.add(Calendar.MINUTE, 15);
//        String vnp_ExpireDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
//
//        List fieldNames = new ArrayList(vnp_Params.keySet());
//        Collections.sort(fieldNames);
//        StringBuilder hashData = new StringBuilder();
//        StringBuilder query = new StringBuilder();
//        Iterator itr = fieldNames.iterator();
//        while (itr.hasNext()) {
//            String fieldName = (String) itr.next();
//            String fieldValue = vnp_Params.get(fieldName);
//            if ((fieldValue != null) && (!fieldValue.isEmpty())) {
//                //Build hash data
//                hashData.append(fieldName);
//                hashData.append('=');
//                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
//                //Build query
//                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII));
//                query.append('=');
//                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
//                if (itr.hasNext()) {
//                    query.append('&');
//                    hashData.append('&');
//                }
//            }
//        }
//        String queryUrl = query.toString();
//        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
//        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
//        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
//        return "redirect:" + paymentUrl;
//    }
//
//    @GetMapping("/payment/result")
//    public String paymentResultForm(@RequestParam("vnp_Amount") String vnp_Amount,
//                                    @RequestParam("vnp_TxnRef") String vnp_TxnRef,
//                                    @RequestParam("vnp_OrderInfo") String vnp_OrderInfo,
//                                    @RequestParam("vnp_PayDate") String vnp_PayDate,
//                                    @RequestParam("vnp_TransactionStatus") String vnp_TransactionStatus,
//                                    Principal principal,
//                                    Model model) {
//        Integer userId = generalService.usernameHandler(principal);
//        if (vnp_TransactionStatus.equalsIgnoreCase("00")) {
////            Long orderId = paymentService.createVNPayOrderFromCart(userId, vnp_Amount, vnp_TxnRef, vnp_TransactionStatus);
////            Order order = orderService.getOrderById(orderId);
////            Payments payments = paymentService.getPaymentByOrderId(orderId);
////            model.addAttribute("vnp_PayDate", vnp_PayDate);
////            model.addAttribute("vnp_OrderInfo", vnp_OrderInfo);
////            model.addAttribute("vnp_TxnRef", vnp_TxnRef);
////            model.addAttribute("vnp_Amount", order.getTotal());
////            model.addAttribute("vnp_TransactionStatus", payments.isStatus());
//        }
//        return "orders/PaymentResult";
//    }
//}
