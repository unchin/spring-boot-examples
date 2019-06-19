package com.steven.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  用户信息表
 * @author StevenGuo 2019-06-18
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer uid;

    /**
     * 账号
     */
    private String username;

    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 用户状态，0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 ， 1:正常状态，2：用户被锁定.
     */
    private String state;

    /**
     * 一个用户具有多个角色
     */
    private List<SysRole> roleList;

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

    public UserInfo() {
    }

}
