package com.example.init.common.result;


/**
 * 返回结果的状态码及提示信息
 */
public enum ResultEnum {

    /**
     * 操作成功，状态码为：200
     * 提示信息为操作成功
     */
    SUCCESS_OPTION("200", "操作成功"),

    /**
     * 认证异常
     */
    AUTHENTICATION_ERROR("401", "请登录"),

    /**
     * 系统异常，状态码为：500
     * 提示信息为系统异常
     */
    SYSTEM_ERROR("500", "系统异常"),

    /*
     * 此项目的自定义异常，状态码为：500+
     * 状态码和提示信息根据需求扩展
     */

    /**
     * 自定义异常，状态码为：501
     * 验证码错误
     */
    VERIFY_CODE_ERROR("501", "验证码错误"),

    /**
     * 自定义异常，状态码为：502
     * 参数错误
     */
    PARAMETER_ERROR("502", "参数错误"),

    /**
     * 自定义异常，状态码为：503
     * 账号错误
     */
    ACCOUNT_ERROR("503", "账号错误"),

    /**
     * 自定义异常，状态码：504
     * 密码错误
     */
    PASSWORD_ERROR("504", "密码错误"),

    /**
     * 自定义异常，状态码：505
     * 账号已存在
     */
    ACCOUNT_EXIST_ERROR("505", "账号已存在"),

    /**
     * 自定义异常，状态码：506
     * 两次输入密码不一致
     */
    PASSWORD_CONFIRM_ERROR("506", "两次输入密码不一致"),

    /**
     * 自定义异常，状态码：507
     * 邮箱已存在
     */
    EMAIL_EXIST_ERROR("507", "邮箱已存在"),

    /**
     * 508 验证码已失效
     */
    VERIFY_CODE_IS_INVALID("508", "验证码已失效"),

    /**
     * 509 用户未注册
     */
    ACCOUNT_IS_NOT_REGISTER("509", "用户未注册"),

    /**
     * 510 禁止对登录中的账号进行操作
     */
    UPDATE_ONESELF_ERROR("510", "禁止对登录中的账号进行操作"),

    /**
     * 511 用户已失效，请重新登录
     */
    RE_LOGIN("511", "用户已失效，请重新登录"),

    /**
     * 512 尚有申请单未完成，请勿重复申请
     */
    RE_APPLY_ERROR("512", "尚有申请单未完成，请勿重复申请"),

    /**
     * 自定义异常，状态码：513
     * 账号已存在
     */
    TC_NUMBER_EXIST_ERROR("513", "标委会编号已存在"),

    /**
     * 自定义异常，状态码：513
     * 账号已存在
     */
    EXCEED_FIVE_ERROR("514", "最多可设置5张轮播图"),

    ;

    /**
     * 返回的状态码
     */
    private String code;
    /**
     * 返回的提示信息
     */
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
