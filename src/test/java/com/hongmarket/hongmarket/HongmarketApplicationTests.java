package com.hongmarket.hongmarket;

import com.hongmarket.hongmarket.enums.RoleEnum;
import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class HongmarketApplicationTests {

    @Autowired
    private IUserService userService;

    @Test

    }

    @Test
    public void queryByIdTest(){

    }
}
