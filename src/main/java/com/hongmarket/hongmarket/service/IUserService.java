package com.hongmarket.hongmarket.service;

import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.vo.ResponseVo;

public interface IUserService {
    /**
     *sign up
     *
     */
    ResponseVo<User> register(User user);

    /**
     *log in
     *
     */
    ResponseVo<User> login(String username, String password);
}
