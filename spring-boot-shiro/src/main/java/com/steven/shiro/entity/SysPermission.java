package com.steven.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  权限表
 * @author StevenGuo 2019-06-18
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串，menu例子：role:*，button例子：role:create，role:update，role:delete，role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private String parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 是否可用
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

    public SysPermission() {
    }

}
