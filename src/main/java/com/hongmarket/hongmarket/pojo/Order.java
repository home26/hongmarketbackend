package com.hongmarket.hongmarket.pojo;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Service
public class Order {
    private Integer id;

    private Long orderNo;

    private Integer userId;

    private Integer shippingId;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;
}