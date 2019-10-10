package com.example.foodmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张帅轲
 * @Date: 2019/10/10 10:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private  Integer userid;
    private String username;
    private String password;
    private String  nickname;
    private String headimg;
    private Integer ustatus;
    private String userphone;
}
