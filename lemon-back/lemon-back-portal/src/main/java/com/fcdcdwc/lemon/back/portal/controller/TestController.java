package com.fcdcdwc.lemon.back.portal.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fcdcdwc.lemon.back.business.mapper.AreaMapper;
import com.fcdcdwc.lemon.back.business.mapper.UserMapper;

import com.fcdcdwc.lemon.back.business.service.AreaService;
import com.fcdcdwc.lemon.back.business.service.UserService;
import com.fcdcdwc.lemon.back.pojo.entity.Area;
import com.fcdcdwc.lemon.back.pojo.entity.User;
import com.fcdcdwc.lemon.back.pojo.enums.SexEnum;

import com.fcdcdwc.lemon.common.exception.Asserts;
import com.fcdcdwc.lemon.common.exception.BusinessException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-06-29 18:13:56
 */
@RestController
@Api(tags = "myBatis-plus测试接口")
@RequestMapping(TestController.BASE_URL)
public class TestController extends BaseResource {

    public static final String BASE_URL = "/info";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaMapper areaMapper;

    @GetMapping(value = "/getUser")
    public User getUser(Long id) {
        return userMapper.selectById(id);
    }

    @GetMapping(value = "/getAreaList")
    public List<Area> getAreaList(String id) {
        LambdaQueryWrapper<Area> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        QueryWrapper<Area> objectQueryWrapper = new QueryWrapper<>();
        objectLambdaQueryWrapper.likeRight(Area::getId, id).in(Area::getLevel, Arrays.asList(1, 2, 3, 4));
//            areaService.get。
        List<Area> areas = areaMapper.selectList(objectLambdaQueryWrapper);
        Map<String, Area> areaMap = areas.stream().collect(Collectors.toMap(Area::getId, v -> v));
        List<Area> list = new ArrayList<>();
        for (Area area : areas) {
            if ("0".equals(area.getParentId())) {
                list.add(area);
            } else {
                Area parent = areaMap.get(area.getParentId());

                if (parent != null) {
                    parent.getChildren().add(area);
                }
            }

        }

        return list;
    }


    @GetMapping(value = "/getUserPage")
    public Page<User> getUserPage(Integer current, Integer size, String name) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, name);
        //new Page()中的两个参数分别是当前页码，每页显示数量
        Page<User> page = userMapper.selectPage(new Page<>(current, size), wrapper);
        List<User> users = page.getRecords();

        return page;
    }


    @GetMapping(value = "/getUser23")
    public User getUser3(Long id) {

        try{
            if (1==1) {
                throw  new Exception("");
            }
        }catch (Exception e){
            Asserts.fail(new BusinessException("budui"));
        }



        return null;
    }

    @GetMapping(value = "/getUser2")
    public User getUser2(Long id) {
        return userService.selectById(id);
    }

    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    @GetMapping(value = "/getUserLis2t")
    public List<User> getUserList2(String name, Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name).between("age", age, age).orderByAsc("id");
        return userMapper.selectList(queryWrapper);
    }


    @PostMapping(value = "/deleteUser")
    public String deleteUser(String name, Integer age) {
        userService.deleteUser(name, age);
        return "ok";
    }

    @PostMapping(value = "/deleteUser2")
    public String deleteUser2(String name, Integer age) {
        userService.deleteUser(name, age);
        return "ok";
    }

    @PostMapping(value = "/updateUser")
    public String deleteUser2(User user) {
        userService.updateUser(user);
        return "ok";
    }


    @PostMapping(value = "/updateUser2")
    public String deleteUser22(String name, String name2, Integer age, Integer age2) {
//        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.like(name != null, "name", name).and(i -> i.gt("age", age).or().isNull("email")).set("email", "svip10086@qq.com");
//        int result = userMapper.update(null, updateWrapper);
//        System.out.println(result > 0 ? "修改成功！" : "修改失败！");
//        System.out.println("受影响的行数为：" + result);


        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName, name)
                .and(i -> i.gt(User::getAge, age).or().isNull(User::getEmail))
                .set(User::getName, name2).set(User::getEmail, "abc@atguigu.com")
                .set(age2 != null, User::getAge, age2);
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result：" + result);

        return "ok";
    }


    @PostMapping(value = "/saveUser")
    public String saveUser(User user) {
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
        return "ok";
    }

    @PostMapping(value = "/saveUsers")
    public String saveUsers() {
        User user = new User();
        user.setAge(1);
        user.setEmail("11");
        user.setName("123");
        User user2 = new User();
        user2.setAge(221);
        user2.setEmail("1331");
        user2.setName("13323");
        user2.setId(1544261999510577153L);

        User user3 = new User();
        user3.setAge(22);
        user3.setEmail("asd ");
        user3.setName("asd ");
        user3.setId(1544261999510577153L);

        List<User> users = Arrays.asList(user, user2, user3);
        userService.saveOrUpdateBatch(users);
        return "ok";
    }


    @GetMapping(value = "/toIndex")
    public ModelAndView toIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(BASE_URL + "/index");
        return mav;
    }
}