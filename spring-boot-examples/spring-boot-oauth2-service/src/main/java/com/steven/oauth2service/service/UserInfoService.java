package com.steven.oauth2service.service;


import com.steven.shiro.entity.UserInfo;

/**
 * 用户信息表
 * @author StevenGuo
 * @date 2019/06/18
 */
public interface UserInfoService {
    UserInfo userInfo(String username);
}
