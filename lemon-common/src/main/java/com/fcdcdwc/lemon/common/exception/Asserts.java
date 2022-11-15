package com.fcdcdwc.lemon.common.exception;


import com.fcdcdwc.lemon.common.interfaces.BusinessTypeInterface;
import org.springframework.stereotype.Component;

/**
 * @author liyandi
 * @program: lemon
 * @description: 断言处理类，用于抛出各种API异常
 * @date 2022-06-28 15:44:01
 */
@Component
public class Asserts {

    public static void fail(Integer code, String message) {
        throw new BusinessException(code, message);
    }

    public static void fail(BusinessTypeInterface businessTypeInterface) { throw new BusinessException(businessTypeInterface); }

}
