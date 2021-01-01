package com.hongmarket.hongmarket.service;

import com.github.pagehelper.PageInfo;
import com.hongmarket.hongmarket.vo.ProductDetailVo;
import com.hongmarket.hongmarket.vo.ProductVo;
import com.hongmarket.hongmarket.vo.ResponseVo;

import java.util.List;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
