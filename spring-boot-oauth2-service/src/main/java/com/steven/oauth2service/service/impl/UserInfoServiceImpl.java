package com.steven.oauth2service.service.impl;

import com.steven.shiro.entity.UserInfo;
import com.steven.shiro.mapper.UserInfoMapper;
import com.steven.shiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表
 * @author StevenGuo
 * @date 2019/06/18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo userInfo(String username) {
        return userInfoMapper.userInfo(username);
    }
}