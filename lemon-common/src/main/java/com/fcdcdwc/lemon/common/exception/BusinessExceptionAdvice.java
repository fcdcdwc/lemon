package com.fcdcdwc.lemon.common.exception;

import com.fcdcdwc.lemon.common.annotation.DisablePackage;
import com.fcdcdwc.lemon.common.enums.BusinessExceptionEnum;
import com.fcdcdwc.lemon.common.interfaces.BusinessTypeInterface;
import com.fcdcdwc.lemon.common.result.BusinessResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

/**
 * @author liyandi
 * @program: lemon
 * @description: 全局自定义异常, 在业务中抛出异常时, 建议使用全局自定义业务返回接口businessExceptionInterface, 通过实现{#getCode(),#getMessage(),getSuccess()}等方法注入异常信息
 * @date 2022-06-28 16:10:12
 */
@ControllerAdvice
public class BusinessExceptionAdvice {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BusinessResult defaultErrorRest(Exception e) {
        return new BusinessResult(BusinessExceptionEnum.STATE_FAILED);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BusinessResult defaultErrorRest(BusinessException e) {
        return new BusinessResult(e);
    }

}
