package com.hongmarket.hongmarket.dao;

import com.hongmarket.hongmarket.HongmarketApplicationTests;
import com.hongmarket.hongmarket.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
public class OrderMapperTest extends HongmarketApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Order order = orderMapper.selectByPrimaryKey(1);
        System.out.println(order.toString());

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}