package com.steven.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo userInfo(@Param("username") String username);

}

