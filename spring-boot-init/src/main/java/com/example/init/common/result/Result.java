package com.example.init.common.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 自定义返回结果
 *
 */
@Data
public class Result<T> {

    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果")
    private T data;
    /**
     * 返回的状态码
     */
    @ApiModelProperty(value = "返回的状态码")
    private String code;
    /**
     * 返回的提示信息
     */
    @ApiModelProperty(value = "返回的提示信息")
    private String msg;

    /**
     * 成功，但不返回data
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS_OPTION.getCode());
        result.setMsg(ResultEnum.SUCCESS_OPTION.getMsg());
        return result;
    }

    /**
     * 成功，返回data
     */
    public static <T> Result<T> success(T object) {
        Result<T> result = success();
        result.setData(object);
        return result;
    }

    /**
     * 失败，返回状态码和状态信息
     */
    public static Result<ResultEnum> error(ResultEnum resultEnum) {
        Result<ResultEnum> result = new Result<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    /**
     * 失败，返回状态码和状态信息<br>
     * 用于全局异常处理类GbaControllerAdvice
     */
    public static <T> Result<T> error(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
