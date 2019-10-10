package com.example.foodmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:27
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreInfo {
    private  Integer storeid;
    private String storename;
    private String addressinfo;
    private String coordinate;
}
