package com.example.foodmanage.service;

import com.example.foodmanage.entity.StoreInfo;

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

}
