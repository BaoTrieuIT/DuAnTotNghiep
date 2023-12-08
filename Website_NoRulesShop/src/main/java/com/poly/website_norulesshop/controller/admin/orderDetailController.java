package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderDetail;
import com.poly.website_norulesshop.service.OrderDetailService;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/orderDetails")
public class orderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("byOrder/{id}")
    public ResponseEntity<?> getOrderDetailByOrderId(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<>();
        try {
            List<OrderDetail> details =  orderDetailService.findByOrderId(id);
            if(details.size() == 0){
                result.put("status", "failed");
                result.put("data", "not found order detail with order id = " + id);
            }else{
                result.put("status", "success");
                result.put("data", details);
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }
}
