package com.hongmarket.hongmarket.pojo;

import lombok.Data;

@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }

    private Boolean productSelected;
}
