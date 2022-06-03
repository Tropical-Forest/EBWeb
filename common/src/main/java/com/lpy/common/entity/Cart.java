package com.lpy.common.entity;

import lombok.Data;

@Data
public class Cart {
    private Integer id;
    private String goodsname;
    private Integer number;
    private Integer price;
    private Integer goodid;
    private Integer uid;
}
