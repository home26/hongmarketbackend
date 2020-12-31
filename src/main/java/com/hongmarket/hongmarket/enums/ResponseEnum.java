package com.hongmarket.hongmarket.enums;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    ERROR(-1, "Error on server"),

    SUCCESS(0,"Succeeded"),

    PASSWORD_ERROR(1, "Wrong password"),

    USERNAME_EXIST(2,"Username exists"),

    PARAM_ERROR(3, "Wrong parameters"),

    EMAIL_EXIST(4,"Email exists"),

    NEED_LOGIN(10, "Please sign up"),

    USERNAME_OR_PASSWORD_ERROR(11, "Wrong username or password"),
    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
