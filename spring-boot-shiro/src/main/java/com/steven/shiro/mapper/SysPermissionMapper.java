package com.steven.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.shiro.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * 权限表
 * @author StevenGuo
 * @date 2019/06/19
 */
@Mapper
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * [查询]  获取角色所拥有的权限
     * @param roleId 角色编号
     * @return java.util.List<com.steven.shiro.entity.SysPermission>
     * @author StevenGuo
     * @date 15:52 2019/6/19
     **/
    List<SysPermission> selectListByRoleId(Integer roleId);
}
