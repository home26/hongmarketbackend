package com.hongmarket.hongmarket.controller;

import com.hongmarket.hongmarket.consts.MallConst;
import com.hongmarket.hongmarket.enums.ResponseEnum;
import com.hongmarket.hongmarket.form.UserLoginForm;
import com.hongmarket.hongmarket.form.UserRegisterForm;
import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.service.IUserService;
import com.hongmarket.hongmarket.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm){
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session){
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        
        //set session
        session.setAttribute(MallConst.CURRENT_USER, userResponseVo.getData());

        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());


        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
