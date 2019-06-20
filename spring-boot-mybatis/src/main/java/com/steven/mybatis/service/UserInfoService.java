package com.steven.mybatis.service;


import com.steven.mybatis.entity.UserInfo;

/**
 * 用户信息表
 * @author StevenGuo
 * @date 2019/06/18
 */
public interface UserInfoService {
    UserInfo userInfo(String username);
}
