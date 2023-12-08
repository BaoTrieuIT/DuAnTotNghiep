package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order_manage")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryQuantityService categoryQuantityService;


    @GetMapping("/awaitingConfirm")
//    public ResponseEntity<?> getAwaitingConfirmed() {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            result.put("status", "success");
//            List<Order> orders = orderService.getOrderAwaitingConfirmation();
//            result.put("data", orders);
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public List<Order> getAwaitingConfirmed() {
        return orderService.getOrderAwaitingConfirmation();
    }

    @GetMapping("/hasBeenShipped")
//    public ResponseEntity<?> getHasBeenShipped() {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            result.put("status", "success");
//            List<Order> orders = orderService.getOrderHasBeenShipped();
//            result.put("data", orders);
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public List<Order> getHasBeenShipped() {
        return orderService.getOrderHasBeenShipped();
    }


    @GetMapping("/inTransit")
//    public ResponseEntity<?> getInTransit() {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            result.put("status", "success");
//            List<Order> orders = orderService.getOrderInTransit();
//            result.put("data", orders);
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public List<Order> getInTransit() {
        return orderService.getOrderInTransit();
    }

    @GetMapping("/deliveryComplete")
//    public ResponseEntity<?> getDeliveryComplete() {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            result.put("status", "success");
//            List<Order> orders = orderService.getOrderDeliveryComplete();
//            result.put("data", orders);
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public List<Order> getDeliveryComplete() {
        return orderService.getOrderDeliveryComplete();
    }

    @GetMapping("/hasBeenCanceled")
//    public ResponseEntity<?> getHasBeenCanceled() {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            result.put("status", "success");
//            List<Order> orders = orderService.getOrderHasBeenCanceled();
//            result.put("data", orders);
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public List<Order> getHasBeenCanceled() {
        return orderService.getOrderHasBeenCanceled();
    }

    @GetMapping("updateOrderStatus")
//    public ResponseEntity<?> updateStatus(@RequestParam("orderId") int orderId, @RequestParam("statusId") int statusId) {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            Order existingOrder = orderService.getOrderById(orderId);
//            OrderStatus orderStatus = orderStatusService.getOrderStatusById(statusId);
//            if (existingOrder != null && orderStatus != null) {
//                existingOrder.setOrderStatus(orderStatus);
//                existingOrder.setOrderUpdateTime(new Date());
//                Order updateOrder = orderService.saveOrder(existingOrder);
//
//                if (statusId == 5) {
//                    List<OrderDetail> details = orderDetailService.findByOrderId(orderId);
////                    details.forEach(orderDetail -> {
////                        orderDetail.getCategoryQuantity().setQuantity(orderDetail.getCategoryQuantity().getQuantity() +  orderDetail.getQuantity());
////                    });
//                    for (OrderDetail orderDetail : details) {
//                        Product product = orderDetail.getProduct();
//                        CategoryQuantity categoryQuantity = orderDetail.getCategoryQuantity();
//                        int quantityOfOrder = orderDetail.getQuantity();
//                        int currentQtyOfProduct = product.getTotalQuantity();
//                        int quantityOfCategory = categoryQuantity.getQuantity();
//                        int updateQtyOfProduct = Math.max(0, currentQtyOfProduct + quantityOfOrder);
//                        int updateQtyOfCategory = Math.max(0, quantityOfCategory + quantityOfOrder);
//                        product.setTotalQuantity(updateQtyOfProduct);
//                        categoryQuantity.setQuantity(updateQtyOfCategory);
//                        categoryQuantityService.saveCategoryQuantity(categoryQuantity);
//                        productService.saveProduct(product);
//                    }
//                }
//                result.put("status", "success");
//                result.put("data", updateOrder);
//            } else {
//                result.put("status", "failed");
//                result.put("data", "can not find with orderId or status");
//            }
//        } catch (Exception e) {
//            result.put("status", "error");
//            result.put("detail", e);
//        }
//        return ResponseEntity.ok(result);
//    }
    public Order updateStatus(@RequestParam("orderId") int orderId, @RequestParam("statusId") int statusId) {
        Order existingOrder = orderService.getOrderById(orderId);
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(statusId);
        if (existingOrder != null && orderStatus != null) {
            existingOrder.setOrderStatus(orderStatus);
            existingOrder.setOrderUpdateTime(new Date());
            if (statusId == 5) {
                List<OrderDetail> details = orderDetailService.findByOrderId(orderId);
                for (OrderDetail orderDetail : details) {
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
            }
            return orderService.saveOrder(existingOrder);
        }
        return null;
    }
}
