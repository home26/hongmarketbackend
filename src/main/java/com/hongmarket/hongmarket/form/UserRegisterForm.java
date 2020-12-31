package com.hongmarket.hongmarket.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {

    @NotBlank(message = "username can not be blank")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
