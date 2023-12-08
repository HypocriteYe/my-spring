package com.example.myspring.controller;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/9 10:01 AM
 */
@RestController
public class MyController {

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @PostMapping("/testHost")
    public String testHost(HttpServletRequest request) throws IOException {

        String requestData = request.getReader().lines()
                .reduce("", (accumulator, actual) -> accumulator + actual);
        return requestData;
    }

    @PostMapping("/testRequest")
    public String testRequest(@RequestBody Map<String, Object> param) {
        System.out.println(JSONObject.toJSONString(param));
        System.out.println(param.get("apiId").toString());
        return "ok";
    }

//    @GetMapping("/hello")
//    public String count() {
//        Long increment = redisTemplate.opsForValue().increment("docker-click-test");
//        return String.valueOf(increment);
//
//    }
}
