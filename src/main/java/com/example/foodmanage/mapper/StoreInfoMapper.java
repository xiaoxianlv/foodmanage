package com.example.foodmanage.mapper;

import com.example.foodmanage.entity.StoreInfo;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:37
 * @Description:
 */
@Mapper
public interface StoreInfoMapper {

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
