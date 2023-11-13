package com.poly.website_norulesshop.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@Getter
public class ContactUsForm {
    private String firstname;
    private String lastname;
    private String email;
    private String subject;
    private String message;

    // Getters and setters

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}



