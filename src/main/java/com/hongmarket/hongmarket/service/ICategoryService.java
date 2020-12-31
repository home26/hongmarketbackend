package com.hongmarket.hongmarket.service;

import com.hongmarket.hongmarket.vo.CategoryVo;
import com.hongmarket.hongmarket.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
