package com.fcdcdwc.lemon.back.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fcdcdwc.lemon.back.pojo.enums.SexEnum;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyandi
 * @program: lemon
 * @description: MyBatis-plus 测试Demo
 * @date 2022-07-05 14:59:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId
    private Long id;

//    @TableField("username")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Boolean isDelete;

    private SexEnum sex;

}
