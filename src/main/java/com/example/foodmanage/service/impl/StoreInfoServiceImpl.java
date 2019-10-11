package com.example.foodmanage.service.impl;

import com.example.foodmanage.entity.StoreInfo;
import com.example.foodmanage.mapper.StoreInfoMapper;
import com.example.foodmanage.service.StoreInfoService;
import com.example.foodmanage.util.MD5Util;
import com.github.pagehelper.PageInfo;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 16:23
 * @Description:
 */
@Service
public class StoreInfoServiceImpl implements StoreInfoService {

    @Autowired
    private StoreInfoMapper storeInfoMapper;


    @Override
    public Integer addStore(StoreInfo storeInfo) {
        return storeInfoMapper.addStore(storeInfo);
    }

    @Override
    public List<StoreInfo> queryStore(StoreInfo storeInfo) {
        return storeInfoMapper.queryStore(storeInfo);
    }

    @Override
    public StoreInfo storeLogin(StoreInfo storeInfo) {
        //密码加密
        storeInfo.setPassword(MD5Util.MD5EncodeUtf8(storeInfo.getPassword()));
        return storeInfoMapper.storeLogin(storeInfo);
    }

    @Override
    public StoreInfo selectOneStoreInfo(Integer storeId) {
        return storeInfoMapper.selectOneStoreInfo(storeId);
    }
}
