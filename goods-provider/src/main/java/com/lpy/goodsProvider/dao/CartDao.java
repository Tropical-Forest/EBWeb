package com.lpy.goodsProvider.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartDao {
    // 根据id删除订单
    int deleteCart(@Param(value = "gid")int gid);

    // 购买商品后添加一条订单数据
    int insertOrder(@Param(value = "goodsname")String goodsname,
                    @Param(value = "number")int number,@Param(value = "price")int price
    ,@Param(value = "uid")int uid);
}
