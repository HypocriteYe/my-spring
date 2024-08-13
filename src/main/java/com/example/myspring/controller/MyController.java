package com.example.myspring.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.myspring.annotation.SingleArg;
import com.example.myspring.tools.DateToLongDeserialize;
import com.example.myspring.tools.LongToDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
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

    @PostMapping("/convert")
    public String testConvert(@RequestBody Time time) {
        return time.date + "" + time.timestamp;
    }

    @PostMapping("/convert2")
    public String testConvert2(@JsonDeserialize(using = LongToDateDeserializer.class) Date date) {
        return date.toString();
    }

    @RequestMapping("/testInt")
    public String testInt(Integer i) {
        System.out.println("i: " + i);
        return "result:" + i;
    }

    @RequestMapping("/testjson")
    public String testJson(@RequestBody MyJson myJson) {
        System.out.println(myJson);
        return myJson.jsName + ":" + myJson.jsValue;
    }

    @PostMapping("/testSingleArg")
    public String testSingleArg(@SingleArg String id) {
        return id;
    }

//    @GetMapping("/hello")
//    public String count() {
//        Long increment = redisTemplate.opsForValue().increment("docker-click-test");
//        return String.valueOf(increment);
//
//    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Time {
//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonDeserialize(using = LongToDateDeserializer.class)
        private Date date;

//        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonDeserialize(using = DateToLongDeserialize.class)
        private Long timestamp;
    }

    @Data
    public static class MyJson {

        @JsonProperty("js_name")
        private String jsName;
        @JsonProperty("js_value")
        private String jsValue;

    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
