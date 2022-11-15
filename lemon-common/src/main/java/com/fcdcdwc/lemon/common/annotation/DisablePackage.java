package com.fcdcdwc.lemon.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liyandi
 * @program: lemon
 * @description: 取消统一返回值包装注解
 * @date 2022-06-29 16:31:36
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DisablePackage {
}
