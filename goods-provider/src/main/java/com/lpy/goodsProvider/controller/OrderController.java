package com.lpy.goodsProvider.controller;

import com.lpy.common.entity.Userorder;
import com.lpy.goodsProvider.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderDao orderDao;
    @RequestMapping(value = "/getAllorder",method = RequestMethod.GET)
    public List<Userorder> getAllorder(@RequestParam(value = "uid")int uid){
        return orderDao.getAllorder(uid);
    }
}
