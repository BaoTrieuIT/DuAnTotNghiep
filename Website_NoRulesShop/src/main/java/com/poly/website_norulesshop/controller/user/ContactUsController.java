package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.ContactUsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUsController {

    @Autowired
    private JavaMailSender emailSender;

    @GetMapping("/contact-us")
    public String showContactForm(Model model) {
        model.addAttribute("contactUsForm", new ContactUsForm());
        return "/contact-us";
    }

    @PostMapping("/contact-us")
    public String submitContactForm(ContactUsForm contactUsForm) {
        // Send email
        sendEmail(contactUsForm);

        // Redirect to a confirmation page
        return "redirect:/contact-success";
    }

    private void sendEmail(ContactUsForm contactUsForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("vietnhqps22017@fpt.edu.vn"); // Replace with your email
        message.setSubject("New Contact Us Form Submission");
        message.setText(
                        "FirstName: " + contactUsForm.getFirstname() + "\n" +
                        "LastName: " + contactUsForm.getLastname() + "\n" +
                        "Email: " + contactUsForm.getEmail() + "\n" +
                        "Subject: " + contactUsForm.getSubject() + "\n" +
                        "Message: " + contactUsForm.getMessage());

        emailSender.send(message);
    }
}
