package com.steven.shiro.mapper;

import com.steven.shiro.entity.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Test
    public void userInfo() {
        Integer uid = 1;
        List<SysRole> sysRoleList = sysRoleMapper.selectListByUid(uid);
        System.out.println(sysRoleList);
    }

}