package com.lpy.goodsProvider.dao;

import com.lpy.common.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingDao {
    // 查询所有购物车
    List<Cart> getAllcart(@Param(value = "uid")int uid);

    // 插入一条购物车
    int intcart(@Param(value = "goodsname")String goodsname,@Param(value = "number")int number,
                @Param(value = "price")int price, @Param(value = "goodid")int goodid, @Param(value = "uid") int uid );

    // 修改购物车商品数量
    int updateCart(@Param(value = "number")int number,@Param(value = "id")int id);
}
