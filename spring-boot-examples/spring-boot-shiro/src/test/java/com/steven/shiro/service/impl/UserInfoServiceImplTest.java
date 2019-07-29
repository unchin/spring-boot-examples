package com.steven.shiro.service.impl;

import com.steven.shiro.entity.UserInfo;
import com.steven.shiro.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void userInfo() {
        String username = "admin";
        UserInfo userInfo = userInfoService.userInfo(username);
        System.out.println(userInfo);
    }
}