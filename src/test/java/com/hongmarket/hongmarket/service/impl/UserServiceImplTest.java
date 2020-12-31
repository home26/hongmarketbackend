package com.hongmarket.hongmarket.service.impl;

import com.hongmarket.hongmarket.HongmarketApplicationTests;
import com.hongmarket.hongmarket.enums.RoleEnum;
import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends HongmarketApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user = new User("jeffery","123456","jeffery@yahoo.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}