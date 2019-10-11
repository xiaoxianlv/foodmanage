package com.example.foodmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.foodmanage.constans.OrderConstans;
import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.entity.StoreInfo;
import com.example.foodmanage.entity.UserInfo;
import com.example.foodmanage.service.CommodityService;
import com.example.foodmanage.service.StoreInfoService;
import com.example.foodmanage.util.RedisUtil;
import com.example.foodmanage.vo.StoreOrderVO;
import com.example.foodmanage.vo.UserOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/11 17:07
 * @Description: 订单的控制层
 */
@Controller
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private CommodityService commodityService;

    @Autowired
    private StoreInfoService storeInfoService;


    /**
     * 在购物车新增订单
     *
     * @param session
     * @param storeInfoId 门店的id
     * @param commodityid 商品的id
     * @param count       数量
     * @param price       本次计算价格
     * @return 订单状态码
     */
    @PostMapping("addOrder")
    @ResponseBody
    public Map<String, Object> addOrder(HttpSession session, Integer storeInfoId, Integer commodityid, Integer count, Float price) {
        //定义返回值
        Map<String, Object> map = new HashMap<>();
        //获取已经登录的用户信息
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //判断用户是否已经登录
        if (ObjectUtils.isEmpty(userInfo)) {
            map.put("dataStatus", "error");
            map.put("dataCode", "10001");
            map.put("message", "系统未监测到用户登录");
            return map;
        }
        //给商家的redis添加数据  用户ID+规格ID+数量（例如：101:1*5）,首先根据redis的key去查询商家信息 进行增加
        Object orderJson = redisUtil.get(OrderConstans.STOREORDER_PREFIX + storeInfoId);
        //创建新的商家订单vo,准备放进去订单
        StoreOrderVO storeOrderVO = new StoreOrderVO();
        storeOrderVO.setUserInfo(userInfo);
        //进行查询数据,查询详细商品，set进去vo
        Commodity commodity = commodityService.selectOneCommodity(commodityid);
        storeOrderVO.setCommodity(commodity);
        storeOrderVO.setCount(count);
        storeOrderVO.setPrice(price);

        //创建新的用户订单vo
        UserOrderVO userOrderVO = new UserOrderVO();
        StoreInfo storeInfo = storeInfoService.selectOneStoreInfo(storeInfoId);
        userOrderVO.setStoreInfo(storeInfo);
        userOrderVO.setCommodity(commodity);
        userOrderVO.setCount(count);
        userOrderVO.setPrice(price);

        try {
            /**
             * 处理添加商家订单
             */
            if (ObjectUtils.isEmpty(orderJson)) {
                //证明redis里面没有这个数据，直接再这里处理添加
                List<StoreOrderVO> storeOrderVOList = new ArrayList<>();
                storeOrderVOList.add(storeOrderVO);
                //再将此list转成string，存入redis即可
                redisUtil.set(OrderConstans.STOREORDER_PREFIX + storeInfoId, JSON.toJSONString(storeOrderVOList));
            } else {
                //转成list
                List<StoreOrderVO> orderJsonVO = JSONArray.parseArray(orderJson.toString(), StoreOrderVO.class);
                //最终给这个list添加进去
                orderJsonVO.add(storeOrderVO);
                //再将此list转成string，存入redis即可
                redisUtil.set(OrderConstans.STOREORDER_PREFIX + storeInfoId, JSON.toJSONString(orderJsonVO));
                //给用户自己的redis添加数据  门店ID+规格ID+数量（例如：10:1*5）
            }

            /**
             * 处理添加用户订单
             */
            //从session中获取用户id
            String userId = String.valueOf(userInfo.getUserid());
            //查询用户order
            Object userOrderJson = redisUtil.get(OrderConstans.USERORDER_PREFIX + userId);
            //判断用户是否有订单
            if (ObjectUtils.isEmpty(userOrderJson)) {
                //没有订单的处理
                List<UserOrderVO> userOrderVOList = new ArrayList<>();
                userOrderVOList.add(userOrderVO);
                redisUtil.set(OrderConstans.USERORDER_PREFIX + userId, JSON.toJSONString(userOrderVOList));
            } else {
                //有订单的处理,转成list
                List<UserOrderVO> userOrderVOList = JSONArray.parseArray(userOrderJson.toString(), UserOrderVO.class);
                userOrderVOList.add(userOrderVO);
                redisUtil.set(OrderConstans.USERORDER_PREFIX + userId, JSON.toJSONString(userOrderVOList));
            }
            map.put("dataStatus", "success");
            map.put("dataCode", "10002");
            map.put("message", "增加商家订单和用户订单成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("dataStatus", "error");
            map.put("dataCode", "10003");
            map.put("message", "程序处理出错");
            return map;
        }
    }
    /**
     * 查询我的店铺的订单
     * @param session
     * @param model
     * @return
     */
    @GetMapping("myStoreOrder")
    public String myStoreOrder(HttpSession session, Model model) {
        //查询用户是否已经登录
        StoreInfo storeInfo = (StoreInfo) session.getAttribute("storeInfo");
        //用户没登录
        if (ObjectUtils.isEmpty(storeInfo)) {
            return "/store/login";
        }
        //获取店铺的id
        String storeId = String.valueOf(storeInfo.getStoreid());
        //查询数据
        Object orderJson = redisUtil.get(OrderConstans.STOREORDER_PREFIX + storeId);
        if(ObjectUtils.isEmpty(orderJson)){
            //没有查询到数据
            return "";
        }else{
            //查询到了数据
            List<StoreOrderVO> storeOrderVOList = JSONArray.parseArray(orderJson.toString(), StoreOrderVO.class);
            model.addAttribute("storeOrderVOList", storeOrderVOList);
            return "/order/myStoreOrder";
        }
    }

    /**
     * 查询我的订单
     * @param session
     * @param model
     * @return
     */
    @GetMapping("myOrder")
    public String myOrder(HttpSession session, Model model) {
      //查询用户
      UserInfo userInfo= (UserInfo) session.getAttribute("userInfo");
        //用户没登录
        if (ObjectUtils.isEmpty(userInfo)) {
            return "redirect:/";
        }
        //查询用户所有的订单从redis中
        Object orderJson = redisUtil.get(OrderConstans.USERORDER_PREFIX + userInfo.getUserid());
        //判读是否有订单
        if(ObjectUtils.isEmpty(orderJson)){
            //没有订单
            return "";
        }else{
            //转换数据
            List<UserOrderVO> userOrderVOList = JSONArray.parseArray(orderJson.toString(), UserOrderVO.class);
            //存入model
            model.addAttribute("userOrderVOList", userOrderVOList);
            return "order/myOrder";
        }


    }


}
