package com.poly.website_norulesshop.config;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get the status code
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // Handle 404 errors
                model.addAttribute("errorCode", "404");
                model.addAttribute("errorMessage", "Page not found");
                return "user/404";
            }
            else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                // Handle 405 errors (Method Not Allowed)
                model.addAttribute("errorCode", "405");
                model.addAttribute("errorMessage", "Method Not Allowed");
                return "user/404";
            }
        }

        // Handle other error cases or return a generic error page
        model.addAttribute("errorCode", "500");
        model.addAttribute("errorMessage", "Internal Server Error");
        return "error";
    }
    public String getErrorPath(){
        return "/error";
    }
}
