package com.hongmarket.hongmarket.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    // 1=in stock 2=out of stock 3-deleted
    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),
    ;

    Integer code;

    ProductStatusEnum(Integer code){
        this.code = code;
    }
}
