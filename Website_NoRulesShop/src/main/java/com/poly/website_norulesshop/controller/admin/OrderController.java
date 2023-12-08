
package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderDetail;
import com.poly.website_norulesshop.entity.OrderStatus;
import com.poly.website_norulesshop.service.OrderDetailService;
import com.poly.website_norulesshop.service.OrderService;
import com.poly.website_norulesshop.service.OrderStatusService;
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
@RequestMapping("/rest/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    OrderDetailService orderDetailService;



    @GetMapping("/awatingConfirm")
    public ResponseEntity<?> getAwaitingConfirmed() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", "success");
            List<Order> orders = orderService.getOrderAwaitingConfirmation();
            result.put("data", orders);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/hasBeenShipped")
    public ResponseEntity<?> getHasBeenShipped() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", "success");
            List<Order> orders = orderService.getOrderHasBeenShipped();
            result.put("data", orders);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/inTransit")
    public ResponseEntity<?> getInTransit() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", "success");
            List<Order> orders = orderService.getOrderInTransit();
            result.put("data", orders);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/deliveryComplete")
    public ResponseEntity<?> getDeliveryComplete() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", "success");
            List<Order> orders = orderService.getOrderDeliveryComplete();
            result.put("data", orders);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/hasBeenCanceled")
    public ResponseEntity<?> getHasBeenCanceled() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", "success");
            List<Order> orders = orderService.getOrderHasBeenCanceled();
            result.put("data", orders);
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("updateOrderStatus")
    public ResponseEntity<?> updateStatus(@RequestParam("orderId") int orderId, @RequestParam("statusId") int statusId){
        Map<String, Object> result = new HashMap<>();
        try {
            Order existingOrder =  orderService.getOrderById(orderId);
            OrderStatus orderStatus =  orderStatusService.getOrderStatusById(statusId);
            if(existingOrder != null && orderStatus != null){
                existingOrder.setOrderStatus(orderStatus);
                existingOrder.setOrderUpdateTime(new Date());
                Order updateOrder = orderService.saveOrder(existingOrder);

                if(statusId == 5){
                    List<OrderDetail> details =  orderDetailService.findByOrderId(orderId);
                    details.forEach(orderDetail -> {
                        orderDetail.getCategoryQuantity().setQuantity(orderDetail.getCategoryQuantity().getQuantity() +  orderDetail.getQuantity());
                    });
                }
                result.put("status", "success");
                result.put("data", updateOrder);
            }else{
                result.put("status", "failed");
                result.put("data", "can not find with orderId or status");
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }

}
