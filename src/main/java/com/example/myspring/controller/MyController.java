package com.example.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/9 10:01 AM
 */
@RestController
public class MyController {

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @GetMapping("/testHost")
    public String testHost(HttpServletRequest request) {

        String remoteHost = request.getRemoteHost();
        return remoteHost;
    }

    @GetMapping("/testRequest")
    public String testReuqest(HttpServletRequest request) {
        return request.toString();
    }

//    @GetMapping("/hello")
//    public String count() {
//        Long increment = redisTemplate.opsForValue().increment("docker-click-test");
//        return String.valueOf(increment);
//
//    }
}
