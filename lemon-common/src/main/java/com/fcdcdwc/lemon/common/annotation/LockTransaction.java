package com.fcdcdwc.lemon.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liyandi
 * @program: lemon
 * @description: Redisson实现事务锁注解
 * @date 2022-06-28 15:44:01
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LockTransaction {

    /**
     * key的规则：
     * 1.填写参数index，例： 0
     * 2.填写对象参数属性，例： #object.attribute
     */
    String key() default "";

    /**
     * key前缀,为空时默认获取方法名
     */
    String prefix() default "";


}
