package com.example.foodmanage.controller;

import com.example.foodmanage.bo.CommodityBO;
import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.entity.CommodityDetail;
import com.example.foodmanage.entity.StoreInfo;
import com.example.foodmanage.service.CommodityService;
import com.example.foodmanage.service.StoreInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:21
 * @Description: 门店的控制层
 */
@Controller
@RequestMapping("storeinfo")
public class StoreInfoController {

    @Autowired
    private StoreInfoService storeInfoService;

    @Autowired
    private CommodityService commodityService;

    /**
     * 门店去登录
     * @return
     */
    @GetMapping("login")
    public String toStoreLogin(){
        return "/store/login";
    }

    /**
     * 处理门店登录信息
     * @param storeInfo
     * @return
     */
    @PostMapping("doStoreLogin")
    public String doStoreLogin(StoreInfo storeInfo, HttpSession session){
        //登录信息查询
        StoreInfo storeLogin = storeInfoService.storeLogin(storeInfo);
        if(ObjectUtils.isEmpty(storeLogin)){
            //没有查询到
            return "/store/login";
        }else{
            session.setAttribute("storeInfo", storeLogin);
            return "redirect:/order/myStoreOrder";
        }
    }


    /**
     * 处理店铺注册
     * @param storeInfo
     * @return
     */
    @PostMapping("doReg")
    public String doReg(StoreInfo storeInfo){
        storeInfoService.addStore(storeInfo);
        return "redirect:/";
    }



    /**
     * 查询店铺
     *
     * @param storeInfo
     * @param model
     * @return
     */
    @GetMapping("query")
    public String index(StoreInfo storeInfo, Model model) {
        //存入model
        model.addAttribute("storeInfo", storeInfo);
        //查询数据
        List<StoreInfo> storeInfoList = storeInfoService.queryStore(storeInfo);
        model.addAttribute("storeInfoList", storeInfoList);
        return "/store/listStore";
    }

    /**
     * 去注册门店的页面
     * @return
     */
    @GetMapping("reg")
    public String reg(){
        return "/store/reg";
    }


    /**
     * 店铺的主页
     * @param storeId 店铺的id
     * @param model
     * @param commodityDetail 套餐
     * @return 店铺主页
     */
    @GetMapping("storeHome")
    public String home(Integer pageNum,Integer pageSize,Integer storeId, Model model, CommodityDetail commodityDetail, CommodityBO  commodity){
        model.addAttribute("commodity", commodity);
        //非空判断
        if(storeId==null){
            return "403";
        }
        //查询店铺的详细信息
        StoreInfo storeInfo = storeInfoService.selectOneStoreInfo(storeId);
        model.addAttribute("storeInfo", storeInfo);
        //查询所有的商品跟套餐的list
        commodity.setStoreid(storeId);

        //查询数据
        PageInfo<Commodity> pageInfo = commodityService.queryAll(pageNum, pageSize, commodity);
        //存入model
        model.addAttribute("pageInfo", pageInfo);
        return "store/home";
    }
}
