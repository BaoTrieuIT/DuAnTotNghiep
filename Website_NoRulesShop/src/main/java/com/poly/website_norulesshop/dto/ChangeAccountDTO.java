package com.poly.website_norulesshop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ChangeAccountDTO {
    String fullname;
    String phonenumber;
    Date birthday;
    String  address;
    Boolean changePassword;
    String newPassword;
}
