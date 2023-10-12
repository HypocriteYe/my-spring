package com.example.myspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MySpringApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    YamlPropertiesFactoryBean yamlPropertiesFactoryBean;

//    @Test
//    void contextLoads() {
//        //        stringRedisTemplate.opsForValue().setIfAbsent("key", "value");
//        stringRedisTemplate.opsForValue().set("key3","value3",60, TimeUnit.MINUTES);
//        String s = stringRedisTemplate.opsForValue().get("key3");
//        System.out.println(s);
//        System.out.println(stringRedisTemplate.getExpire("key3"));
//        stringRedisTemplate.expire("key3", 0, TimeUnit.SECONDS);
//        System.out.println(stringRedisTemplate.getExpire("key3"));
//    }
//
//    @Test
//    void testConvert() {
//        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
//        Properties properties = yamlPropertiesFactoryBean.getObject();
//        System.out.println(properties);
//    }

}
