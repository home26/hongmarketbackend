package com.hongmarket.hongmarket;

import com.hongmarket.hongmarket.dao.CategoryMapper;
import com.hongmarket.hongmarket.dao.OrderMapper;
import com.hongmarket.hongmarket.pojo.Category;
import com.hongmarket.hongmarket.pojo.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HongmarketApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void queryByIdTest(){

    }
}
