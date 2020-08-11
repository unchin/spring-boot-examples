package com.example.init.common.exception;


import com.example.init.common.result.ResultEnum;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException{

    /**
     * 异常状态码
     */
    private final String code;
    /**
     * 异常信息
     */
    private final String msg;

    public ServiceException(ResultEnum resultEnum) {

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
