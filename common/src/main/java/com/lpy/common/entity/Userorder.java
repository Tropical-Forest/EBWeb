package com.lpy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Userorder {
    private Integer id;
    private String goodsname;
    private Integer number;
    private Integer price;
    private Date time;
    private Integer uid;
}
