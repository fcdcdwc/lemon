package com.fcdcdwc.lemon.common.result;

import com.fcdcdwc.lemon.common.enums.BusinessExceptionEnum;
import com.fcdcdwc.lemon.common.exception.Asserts;
import com.fcdcdwc.lemon.common.interfaces.BusinessTypeInterface;

/**
 * @author liyandi
 * @program: lemon
 * @description: 接口响应返回值统一包装类
 * @date 2022-06-28 15:44:01
 */
public class BusinessResult<T> implements BusinessTypeInterface {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * code码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 数据
     */
    private T data;


    public BusinessResult(T data) {
        if (data instanceof BusinessTypeInterface) {
            setExceptionResult((BusinessTypeInterface) data);
        } else {
            setSuccessResult(data);
        }

    }
    public BusinessResult(Boolean success, Integer code) {
        this.success = success;
        this.code = code;
    }

    public BusinessResult(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BusinessResult(Boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


    @Override
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    private void setSuccessResult(T data) {
        BusinessExceptionEnum businessExceptionEnum = BusinessExceptionEnum.STATE_SUCCESS;
        this.success = businessExceptionEnum.getSuccess();
        this.code = businessExceptionEnum.getCode();
        this.message = businessExceptionEnum.getMessage();
        this.data = data;
    }

    private void setExceptionResult(BusinessTypeInterface data) {
        this.success = data.getSuccess();
        this.code = data.getCode();
        this.message = data.getMessage();
    }

}
