package com.steven.oauth2service.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.oauth2service.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo userInfo(@Param("username") String username);

}

