package com.hongmarket.hongmarket.dao;

import com.hongmarket.hongmarket.HongmarketApplicationTests;
import com.hongmarket.hongmarket.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
public class CategoryMapperTest extends HongmarketApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findById() {
        Category category = categoryMapper.findById(100001);
        System.out.println(category.toString());
    }

    @Test
    public void queryById() {
        Category category = categoryMapper.queryById(100001);
        System.out.println(category.toString());
    }
}