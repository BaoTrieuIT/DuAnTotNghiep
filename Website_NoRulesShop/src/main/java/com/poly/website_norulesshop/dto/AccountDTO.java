package com.poly.website_norulesshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {
    private Integer account_id;

    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;

    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Vui lòng nhập đúng định dạng")
    private String email;

    @NotBlank(message = "Vui lòng nhập tên tài khoản")
    private String username;

    @NotBlank(message = "Vui lòng nhập lại mật khẩu ")
    private String confirmPassword;

}
