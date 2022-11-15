package com.fcdcdwc.lemon.common.exception;

import com.fcdcdwc.lemon.common.enums.BusinessExceptionEnum;
import com.fcdcdwc.lemon.common.interfaces.BusinessTypeInterface;

/**
 * @author liyandi
 * @program: lemon
 * @description: 全局自定义异常, 在业务中抛出异常时, 建议使用全局自定义业务返回接口businessExceptionInterface, 通过实现{#getCode(),#getMessage(),getSuccess()}等方法注入异常信息
 * @date 2022-06-28 16:10:12
 */
public class BusinessException extends RuntimeException implements BusinessTypeInterface {

    /**
     * code码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;


    public BusinessException(String message) {
        super(message);
        this.code = BusinessExceptionEnum.STATE_FAILED.getCode();
        this.message = message;
    }

    public BusinessException(BusinessTypeInterface businessTypeInterface) {
        super(businessTypeInterface.getMessage());
        this.code = businessTypeInterface.getCode();
        this.message = businessTypeInterface.getMessage();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Boolean getSuccess() {
        return Boolean.FALSE;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
