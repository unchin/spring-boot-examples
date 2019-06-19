package com.steven.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  角色表
 * @author StevenGuo 2019-06-18
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;

    /**
     * 角色描述，ui界面显示使用
     */
    private String description;

    /**
     * 是否可用，如果不可用将不会添加给用户
     */
    private String available;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 操作时间
     */
    private Date operateDate;

    /**
     * 创建用户
     */
    private String creator;

    /**
     * 操作用户
     */
    private String operator;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色 -- 权限关系：多对多关系;
     */
    private List<SysPermission> permissions;

    /**
     * 用户 - 角色关系定义;
     */
    private List<UserInfo> userInfos;// 一个角色对应多个用户

    public SysRole() {
    }

}
