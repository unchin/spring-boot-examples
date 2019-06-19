package com.steven.shiro.service.impl;

import com.steven.demo.shiro.mapper.UserInfoMapper;
import com.steven.service.UserInfoService;
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
}