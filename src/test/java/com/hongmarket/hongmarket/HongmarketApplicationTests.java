package com.hongmarket.hongmarket;

import com.google.gson.Gson;
import com.hongmarket.hongmarket.enums.ResponseEnum;
import com.hongmarket.hongmarket.enums.RoleEnum;
import com.hongmarket.hongmarket.form.CartAddForm;
import com.hongmarket.hongmarket.form.CartUpdateForm;
import com.hongmarket.hongmarket.pojo.User;
import com.hongmarket.hongmarket.service.ICartService;
import com.hongmarket.hongmarket.service.IProductService;
import com.hongmarket.hongmarket.service.IUserService;
import com.hongmarket.hongmarket.vo.CartVo;
import com.hongmarket.hongmarket.vo.ProductDetailVo;
import com.hongmarket.hongmarket.vo.ProductVo;
import com.hongmarket.hongmarket.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
public class HongmarketApplicationTests {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @Test
    void contextLoads() {
        //ResponseVo<ProductDetailVo> responseVo = productService.detail(27);
        //Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }

    @Test
    public void queryByIdTest(){
        CartAddForm form = new CartAddForm();
        form.setProductId(29);
        form.setSelected(true);
        cartService.add(1,form);
    }

    @Test
    public void cartListTest(){
        //ResponseVo<CartVo> list = cartService.list(1);
        //log.info("list={}", list);
    }

    @Test
    public void update(){
        //CartUpdateForm form = new CartUpdateForm();
        //form.setQuantity(10);
        //form.setSelected(false);
        //ResponseVo<CartVo> responseVo = cartService.update(1,26, form);
        //log.info("result={}", responseVo);
    }

    @Test
    public void delete(){
        //ResponseVo<CartVo> responseVo = cartService.delete(1,26);
        //log.info("result={}", responseVo);
    }

    @Test
    public void selectAll(){
        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
        log.info("result={}", responseVo);
    }

    @Test
    public void unSelectAll(){
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(1);
        log.info("result={}", responseVo);
    }

    @Test
    public void sum(){
        ResponseVo<Integer> responseVo = cartService.sum(1);
        log.info("result={}", responseVo);
    }
}
