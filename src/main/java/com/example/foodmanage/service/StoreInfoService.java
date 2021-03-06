package com.example.foodmanage.service;

import com.example.foodmanage.entity.StoreInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:22
 * @Description:
 */
public interface StoreInfoService {

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    Integer addStore(StoreInfo storeInfo);


    /**
     * 查询店铺
     * @param storeInfo
     * @return
     */
    List<StoreInfo> queryStore(StoreInfo storeInfo);


    /**
     * 登录store
     * @param storeInfo
     * @return
     */
    StoreInfo storeLogin(StoreInfo storeInfo);



    /**
     * 查询店铺的详细信息
     * @param storeId
     * @return
     */
    StoreInfo selectOneStoreInfo(Integer storeId);
}
