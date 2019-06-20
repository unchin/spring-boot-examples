package com.steven.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.steven.shiro.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表
 * @author StevenGuo
 * @date 2019/06/19
 */
@Mapper
@Repository
public interface SysRoleMapper  {

    /**
     * [查询] 获取用户所拥有的角色
     * @param uid 用户编号
     * @return java.util.List<com.steven.shiro.entity.SysRole>
     * @author StevenGuo
     * @date 15:36 2019/6/19
     **/
    List<SysRole> selectListByUid(@Param("uid") Integer uid);
}

