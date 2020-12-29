package com.hongmarket.hongmarket;

import com.hongmarket.hongmarket.dao.CategoryMapper;
import com.hongmarket.hongmarket.pojo.Category;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringBootTest.class)
@SpringBootTest
class HongmarketApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
        Category category = categoryMapper.findById(100001);
        System.out.println(category.toString());
    }

}
