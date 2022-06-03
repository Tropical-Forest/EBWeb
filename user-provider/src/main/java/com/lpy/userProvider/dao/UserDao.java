package com.lpy.userProvider.dao;

import com.lpy.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

@Mapper
public interface UserDao {
    //用户注册接口
    int register (@Param(value = "upassword")String upassword,
                  @Param(value = "uname")String uname,
                  @Param(value = "usex")String usex);
    //用户登录接口
    User login(@Param(value = "uname") String uname);
}
