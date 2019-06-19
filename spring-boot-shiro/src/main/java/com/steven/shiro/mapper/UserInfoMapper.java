package com.steven.shiro.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.shiro.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}

