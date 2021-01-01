package com.hongmarket.hongmarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hongmarket.hongmarket.dao.ProductMapper;
import com.hongmarket.hongmarket.enums.ResponseEnum;
import com.hongmarket.hongmarket.pojo.Product;
import com.hongmarket.hongmarket.service.ICategoryService;
import com.hongmarket.hongmarket.service.IProductService;
import com.hongmarket.hongmarket.vo.ProductDetailVo;
import com.hongmarket.hongmarket.vo.ProductVo;
import com.hongmarket.hongmarket.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hongmarket.hongmarket.enums.ProductStatusEnum.DELETE;
import static com.hongmarket.hongmarket.enums.ProductStatusEnum.OFF_SALE;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if(categoryId != null){
            categoryService.findSubCategoryId(categoryId,categoryIdSet);
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = productList.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);

        if(product.getStatus().equals(OFF_SALE.getCode())
                || product.getStatus().equals(DELETE.getCode())){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        //we assume no body is going to buy more than 100 items(avoid the attack of web crawler)
        productDetailVo.setStock(product.getStock() > 100 ? 100 : product.getStock());
        return ResponseVo.success(productDetailVo);
    }
}
