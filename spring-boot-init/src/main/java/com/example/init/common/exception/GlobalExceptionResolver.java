package com.example.init.common.exception;


import com.example.init.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 捕捉自定义异常类 SubjectLibException.class
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public Result gbaErrorHandler(ServiceException ex) {

        logger.error(ex.getMsg());

        return Result.error(ex.getCode(), ex.getMsg());

    }

    /**
     * 捕捉全局异常 Exception.class
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {

        logger.error(ex.getMessage());

        return Result.error("-1", ex.getMessage());

    }
}
