package com.hongmarket.hongmarket.service.impl;

import com.hongmarket.hongmarket.dao.UserMapper;
import com.hongmarket.hongmarket.enums.ResponseEnum;
import com.hongmarket.hongmarket.enums.RoleEnum;
import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.service.IUserService;
import com.hongmarket.hongmarket.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> register(User user) {
        //username must be distinct
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if(countByUsername > 0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        //Email must be distinct
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if(countByEmail > 0){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());

        //encrypt password with MD5
        user.setPassword(DigestUtils.
                md5DigestAsHex(user.getPassword().
                        getBytes(StandardCharsets.
                                UTF_8)));


        //write into database
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null){
            //user does not exist
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            //wrong password
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        //wrong username or password
        user.setPassword("");
        return ResponseVo.success(user);
    }

}
