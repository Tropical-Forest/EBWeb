package com.lpy.goodsConsumer.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception
    {
        System.out.println("我是拦截器，我证明我进来了");
        HttpSession session = request.getSession();
        String userInfo = (String) session.getAttribute("uaccount");
        if(userInfo==null)
        {
            System.out.println("我证明用户没有登录");
            response.sendRedirect(request.getContextPath()+"http://localhost:8893/admin/tologin");
            return false;
        }
        System.out.println("我证明用户已经登录了");
        return true;
    }
}
