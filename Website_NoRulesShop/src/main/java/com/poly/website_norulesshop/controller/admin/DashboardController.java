package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.dto.OrderDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.OrderDetailService;
import com.poly.website_norulesshop.service.OrderService;
import com.poly.website_norulesshop.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/dashboard")
public class DashboardController {
    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("revenue")
    public List<OrderDTO> getTotalRevenue() {
        return orderService.getAllOrdersDashboard();
    }

    //Customer
    @GetMapping("customers/{timeCustomer}")
    public Integer getTotalCustomers(@PathVariable("timeCustomer") String time) {
        return switch (time) {
            case "customer_today" -> accountService.totalAccountUser(time);
            case "customer_month" -> accountService.totalAccountUser(time);
            case "customer_year" -> accountService.totalAccountUser(time);
            default -> throw new IllegalArgumentException("Invalid time parameter: " + time);
        };
    }

    //Sales
    @GetMapping("sales/{timeSales}")
    public Integer getToTalSales(@PathVariable("timeSales") String time) {


        return switch (time) {
            case "sales_today" -> orderDetailService.totalSales(time);
            case "sales_month" -> orderDetailService.totalSales(time);
            case "sales_year" -> orderDetailService.totalSales(time);
            default -> throw new IllegalArgumentException("Invalid time parameter: " + time);
        };

    }

    //Revenue
    @GetMapping("revenue/{timeRevenue}")
    public Integer getToTalRevenue(@PathVariable("timeRevenue") String time) {

        return switch (time) {
            case "revenue_today" -> orderService.totalRevenue(time);
            case "revenue_month" -> orderService.totalRevenue(time);
            case "revenue_year" -> orderService.totalRevenue(time);
            default -> throw new IllegalArgumentException("Invalid time parameter: " + time);
        };

    }
}
