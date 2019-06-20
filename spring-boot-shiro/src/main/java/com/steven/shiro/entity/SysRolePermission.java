package com.steven.shiro.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 *  角色权限表
 * @author StevenGuo 2019-06-19
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色权限
     */
    private Integer permissionId;

    /**
     * 角色编号
     */
    private Integer roleId;

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

    public SysRolePermission() {
    }

}
