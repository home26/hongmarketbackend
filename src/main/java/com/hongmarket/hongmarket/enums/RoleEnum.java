package com.hongmarket.hongmarket.enums;

import lombok.Getter;

/* 0==administrator 1=guest
 *
 */
@Getter
public enum RoleEnum {
    ADMIN(0),

    CUSTOMER(1),

    ;
    Integer code;
    RoleEnum(Integer code){
        this.code = code;
    }
}
