package com.fcdcdwc.lemon.common.result;

import com.fcdcdwc.lemon.common.annotation.DisablePackage;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
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

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (this.getClass().getPackage().getName().contains(returnType.getDeclaringClass().getPackage().getName())) {
            Method method = returnType.getMethod();
            if (!Void.TYPE.equals(method.getReturnType())) {
                DisablePackage disablePackage = method.getAnnotation(DisablePackage.class);
                if (disablePackage == null) {
                    BusinessResult businessResult = new BusinessResult(body);
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

}
