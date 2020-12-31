package com.hongmarket.hongmarket.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    @NotBlank(message = "username can not be blank")
    private String username;

    @NotBlank
    private String password;
}
