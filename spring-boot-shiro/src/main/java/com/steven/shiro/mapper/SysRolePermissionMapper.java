package com.steven.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.shiro.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
}
