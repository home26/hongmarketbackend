package com.hongmarket.hongmarket.dao;

import com.hongmarket.hongmarket.pojo.MallShipping;
import com.hongmarket.hongmarket.pojo.MallShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallShippingMapper {
    long countByExample(MallShippingExample example);

    int deleteByExample(MallShippingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallShipping record);

    int insertSelective(MallShipping record);

    List<MallShipping> selectByExample(MallShippingExample example);

    MallShipping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallShipping record, @Param("example") MallShippingExample example);

    int updateByExample(@Param("record") MallShipping record, @Param("example") MallShippingExample example);

    int updateByPrimaryKeySelective(MallShipping record);

    int updateByPrimaryKey(MallShipping record);
}