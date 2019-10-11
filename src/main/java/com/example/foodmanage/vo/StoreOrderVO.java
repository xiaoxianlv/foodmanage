package com.example.foodmanage.vo;

import com.example.foodmanage.entity.Commodity;
import com.example.foodmanage.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/11 17:03
 * @Description: 商户的ordervo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreOrderVO {
    /**
     * 用户名、手机号
     */
    private UserInfo userInfo;
    /**
     * 产品名称、数量
     */
    private Commodity commodity;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 总价
     */
    private Float price;
}
