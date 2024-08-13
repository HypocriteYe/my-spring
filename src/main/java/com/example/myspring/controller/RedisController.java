package com.example.myspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description
 * @Author ygl
 * @Create 2024/4/9 16:55
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {


    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/rt/set")
    public String RTSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @GetMapping("/rt/get")
    public String RTGet(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        log.info("/rt/get: {}", o);
        return (String) o;
    }

    @GetMapping("/srt/set")
    public String SRTSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "success";
    }

    @GetMapping("/srt/get")
    public String SRTGet(String key) {
        String o = stringRedisTemplate.opsForValue().get(key);
        log.info("/srt/get: {}", o);
        return o;
    }

    @GetMapping("/srt/incr")
    public String SRTIncr(String key) {
        Long increment = stringRedisTemplate.opsForValue().increment(key);
        return increment.toString();
    }
}
