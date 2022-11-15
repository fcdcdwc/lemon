package com.fcdcdwc.lemon.back.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fcdcdwc.lemon.back.business.mapper.UserMapper;
import com.fcdcdwc.lemon.back.pojo.entity.User;
import com.fcdcdwc.lemon.common.enums.BusinessExceptionEnum;
import com.fcdcdwc.lemon.common.exception.Asserts;
import com.fcdcdwc.lemon.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-07-05 18:13:59
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IService<User> {

    @Autowired
    private UserMapper userMapper;


    public User selectById(Long id) {
        BusinessExceptionEnum stateFailed = BusinessExceptionEnum.STATE_FAILED;
        if (id == null) {
            Asserts.fail(new BusinessException(222, "不对"));
        }
        return userMapper.selectById(id);
    }

    public void deleteUser(String name, Integer age) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    public void updateUser(User user) {
    }
}
