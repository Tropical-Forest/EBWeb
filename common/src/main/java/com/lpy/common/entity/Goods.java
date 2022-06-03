package com.lpy.common.entity;

import lombok.Data;

@Data
public class Goods {
    private Integer gid;
    private String gname;
    private String gremain;
    private String gdetails;
    private Integer gprice;
    private Integer types;
}
