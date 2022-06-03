package com.lpy.goodsConsumer.controller;

import com.lpy.common.entity.Cart;
import com.lpy.common.entity.Goods;
import com.lpy.goodsConsumer.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    // 退出登录并跳转会登录页面
    @GetMapping(value = "/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("uaccount");
        return "redirect:http://localhost:8893/admin/tologin";
    }

    // 首页查询全部商品并分类显示
    @GetMapping(value = "/getAll")
    public String getAll(HttpServletRequest request, String uaccount, String upassword, String uname, String usex, HttpSession session) {
        session.setAttribute("uaccount", uaccount);
        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getAllgoods();
        for (Goods newGoods : oldgoods) {
            System.out.println(newGoods.getTypes());
            if (newGoods.getTypes().equals(1)) {
                goods1.add(newGoods);
            }
            if (newGoods.getTypes().equals(2)) {
                goods2.add(newGoods);
            }
            if (newGoods.getTypes().equals(3)) {
                goods3.add(newGoods);
            }
            if (newGoods.getTypes().equals(4)) {
                goods4.add(newGoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";

    }

    //商品详情 ---即根据id查询单个商品
    @GetMapping(value = "/detail")
    public String detail(HttpServletRequest request, int gid) {
        request.setAttribute("detail", goodsService.getOnegid(gid));
        return "detail";
    }

    // 商品首页搜索 ----- 根据名称模糊查找商品
    @GetMapping(value = "/getOne")
    public String getOne(HttpServletRequest request, String name) {

        List<Goods> goods1 = new ArrayList<>();
        List<Goods> goods2 = new ArrayList<>();
        List<Goods> goods3 = new ArrayList<>();
        List<Goods> goods4 = new ArrayList<>();
        List<Goods> oldgoods = goodsService.getOnegoods(name);
        for (Goods newGoods : oldgoods) {
            System.out.println(newGoods.getTypes());
            if (newGoods.getTypes().equals(1)) {
                goods1.add(newGoods);
            }
            if (newGoods.getTypes().equals(2)) {
                goods2.add(newGoods);
            }
            if (newGoods.getTypes().equals(3)) {
                goods3.add(newGoods);
            }
            if (newGoods.getTypes().equals(4)) {
                goods4.add(newGoods);
            }
        }
        request.setAttribute("goods1", goods1);
        request.setAttribute("goods2", goods2);
        request.setAttribute("goods3", goods3);
        request.setAttribute("goods4", goods4);
        return "index";
    }

    // 加入购物车-将商品加入购物车之前先查询购物车是否有此商品，如果有就修改商品数量，如果没有就添加商品
    @GetMapping(value = "cart")
    public String cart(HttpServletRequest request, String name, String price, String che, String number, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        List<Cart> usercart = goodsService.getAllcart(Integer.parseInt(uid));
        int n = Integer.parseInt(price);
        for (int i = 0; i < usercart.size(); i++) {
            if (usercart.get(i).getGoodid() == Integer.parseInt(che)) {
                goodsService.updateCart(Integer.parseInt(number), usercart.get(i).getId());
                return "redirect:/goods/cartAll";
            }
        }
        goodsService.intcart(name, Integer.parseInt(number), n, Integer.parseInt(che), Integer.parseInt(uid));
        return "redirect:/goods/cartAll";
    }

    //查询购物车全部商品
    @GetMapping(value = "cartAll")
    public String cartAll(HttpServletRequest request, HttpSession session) {
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("carts", goodsService.getAllcart(Integer.parseInt(uid)));
        return "Settle";
    }

    // 删除购物车，根据id删除购物车商品
    @GetMapping(value = "deleteCart")
    public String deleteCart(HttpServletRequest request, String did) {
        goodsService.deleteCart(Integer.parseInt(did));
        return "redirect:/goods/cartAll";
    }

    // 添加订单并调用购物车功能（即购买之后删除购物车商品）
    @GetMapping(value = "/paygoods")
    public String paygoods(HttpServletRequest request, String[] goodid, String[] numaa,
                           HttpSession session, String[] id) {
        String uid = (String) session.getAttribute("uaccount");
        if (goodid.length == 0 || numaa.length == 0 || id.length == 0) {
            return "redirect:/goods/cartAll";
        } else {
            for(int i=0;i<goodid.length;i++){
                goodsService.insertOrder(
                        goodsService.getOnegid(Integer.parseInt(goodid[i])).getGname(),
                        Integer.parseInt(numaa[i]),Integer.parseInt(numaa[i])*goodsService.getOnegid(Integer.parseInt(goodid[i])).getGprice(),
                        Integer.parseInt(uid)
                );
                goodsService.deleteCart(goodsService.deleteCart(Integer.parseInt(id[i])));
            }
            request.setAttribute("mag3","购买失败");
            return "redirect:/goods/getAllorder";
        }

    }

    @GetMapping(value = "/getAllorder")
    public String getAllorder(HttpServletRequest request,HttpSession session){
        String uid = (String) session.getAttribute("uaccount");
        request.setAttribute("order",goodsService.getAllorder(Integer.parseInt(uid)));
        if(uid.equals(null)){
            return "redirect:http://localhost:8893/admin/tologin";
        }
        return "order";
    }
}
