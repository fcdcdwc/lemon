package com.fcdcdwc.lemon.back.pojo.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-07-14 10:57:31
 */
@Data
public class TestExcelBean {


    @ExcelProperty(value = "属性名", index = 0)
    private String name;

    @ExcelProperty(value = "属性值", index = 1)
    private String value;

    @ExcelProperty(value = "属性类型", index = 2)
    private String attrType;

    @ExcelProperty(value = "选择类型", index = 3)
    private String selectType;

}
