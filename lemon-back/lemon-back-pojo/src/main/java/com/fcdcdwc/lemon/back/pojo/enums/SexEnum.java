package com.fcdcdwc.lemon.back.pojo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-07-06 14:37:28
 */
@Getter
@ToString
public enum  SexEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    //将注解所标识的属性的值存储到数据库中
    @EnumValue
    private Integer sex;
    @JsonValue
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }



}
