package com.fcdcdwc.lemon.back.portal.controller;


import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fcdcdwc.lemon.back.business.mapper.AreaMapper;
import com.fcdcdwc.lemon.back.business.mapper.UserMapper;
import com.fcdcdwc.lemon.back.business.service.AreaService;
import com.fcdcdwc.lemon.back.business.service.UserService;
import com.fcdcdwc.lemon.back.pojo.bean.TestExcelBean;
import com.fcdcdwc.lemon.back.pojo.entity.Area;
import com.fcdcdwc.lemon.back.pojo.entity.User;
import com.fcdcdwc.lemon.back.pojo.enums.SexEnum;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-06-29 18:13:56
 */
@RestController
@Api(tags = "Excel测试接口")
@RequestMapping(TestController2.BASE_URL)
public class TestController2 extends BaseResource {

    public static final String BASE_URL = "/excel";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaMapper areaMapper;


    @GetMapping(value = "/getExcel")
    public String getExcel(HttpServletResponse response) throws IOException {
        List<TestExcelBean> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            TestExcelBean data = new TestExcelBean();
            data.setAttrType("字符串" + i);
            data.setName("esdfsdf");
            data.setSelectType("0.56");
            data.setValue("qwr");
            list.add(data);
        }

        EasyExcel.write(response.getOutputStream(), TestExcelBean.class)
                .sheet("模1板")
                .doWrite(() -> list);


        return "OK";

    }

}