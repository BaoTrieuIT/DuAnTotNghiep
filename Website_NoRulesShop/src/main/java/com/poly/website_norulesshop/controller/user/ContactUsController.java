package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.ContactUsForm;
import com.poly.website_norulesshop.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ContactUsController {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    EmailService emailService;
    @GetMapping("/contact-us")
    public String showContactForm(Model model) {
        model.addAttribute("contactUsForm", new ContactUsForm());
        return "user/contact_us";
    }

    @PostMapping("/contact-us")
    public String submitContactForm(ContactUsForm contactUsForm) {
        // Send email
        sendEmail(contactUsForm);

        // Redirect to a confirmation page
        return "redirect:/contact-success";
    }

    private void sendEmail(ContactUsForm contactUsForm) {
        //String to = "vietnhqps22017@fpt.edu.vn";
        String to = "canhdang341@gmail.com";
        emailService.sendEmailContactUs(to,contactUsForm.getEmail(),contactUsForm.getMessage(),contactUsForm.getSubject(),contactUsForm.getFirstname(),contactUsForm.getLastname());
    }
}
