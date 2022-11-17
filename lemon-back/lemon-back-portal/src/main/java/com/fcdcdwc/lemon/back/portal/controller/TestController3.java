package com.fcdcdwc.lemon.back.portal.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author liyandi
 * @program: lemon
 * @description:
 * @date 2022-11-17 14:15:57
 */
@RestController
@Api(tags = "redis测试接口")
@RequestMapping(TestController3.BASE_URL)
public class TestController3 extends BaseResource {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final String BASE_URL = "/redis";

    @PostMapping(value = "/add")
    public String addRedis(String key,String value) throws IOException {
        redisTemplate.opsForSet().add(key,value,100, TimeUnit.MINUTES);
        return "ok";
    }

    @GetMapping(value = "/get")
    public String getRedis(String key) throws IOException {
        return redisTemplate.getExpire(key).toString();
    }



}