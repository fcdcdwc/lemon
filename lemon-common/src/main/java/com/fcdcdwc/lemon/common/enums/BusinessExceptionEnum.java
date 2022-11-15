package com.fcdcdwc.lemon.common.enums;

import com.fcdcdwc.lemon.common.interfaces.BusinessTypeInterface;

/**
 * @author liyandi
 * @program: lemon
 * @description: 响应状态类型枚举类, 定义STATE_SUCCESS通用成功返回， 定义SSTATE_FAILED通用失败返回, 具体业务异常由service定义
 * @date 2022-06-29 15:14:10
 */
public enum BusinessExceptionEnum implements BusinessTypeInterface {

    /**
     * 正常返回
     */
    STATE_SUCCESS(200, "成功", Boolean.TRUE),

    /**
     * 异常返回
     */
    STATE_FAILED(500, "服务器开小差了请稍后再试", Boolean.FALSE);

    /**
     * code码
     */
    private Integer code;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 是否成功
     */
    private Boolean success;

    BusinessExceptionEnum(Integer code, String message, Boolean success) {
        this.code = code;
        this.message = message;
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

    @Override
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
