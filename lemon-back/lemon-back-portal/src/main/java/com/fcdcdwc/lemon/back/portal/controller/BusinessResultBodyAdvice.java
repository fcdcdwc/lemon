package com.fcdcdwc.lemon.back.portal.controller;

import com.fcdcdwc.lemon.common.annotation.DisablePackage;
import com.fcdcdwc.lemon.common.enums.BusinessExceptionEnum;
import com.fcdcdwc.lemon.common.exception.BusinessException;
import com.fcdcdwc.lemon.common.result.BusinessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author liyandi
 * @program: lemon
 * @description: 接口响应返回值统一包装
 * @date 2022-06-29 16:34:12
 */
@ControllerAdvice
public class BusinessResultBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getDeclaringClass().getPackage().getName().contains(this.getClass().getPackage().getName())) {
            Method method = returnType.getMethod();
            if (!Void.TYPE.equals(method.getReturnType())) {
                DisablePackage disablePackage = method.getAnnotation(DisablePackage.class);
                if (disablePackage == null) {
                    BusinessResult<Object> businessResult = new BusinessResult<>(body);
                    body = businessResult;
                }
            }
        }
        return body;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BusinessResult<BusinessExceptionEnum> defaultErrorRest(Exception e) {
        logger.error(e.getMessage(),e);
        return new BusinessResult<>(BusinessExceptionEnum.STATE_FAILED);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BusinessResult<BusinessException> defaultErrorRest(BusinessException e) {
        logger.error(e.getMessage());
        return new BusinessResult<>(e);
    }

}
