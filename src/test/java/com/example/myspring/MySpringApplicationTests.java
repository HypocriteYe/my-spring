package com.example.myspring;

import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MySpringApplicationTests {

//    @Autowired
//    StringRedisTemplate stringRedisTemplate;

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

    @Test
    public void testLists() {
//        Long id = null;
//        List<Long> list = Lists.newArrayList(id);
//        System.out.println(list);

        Object[] o = null;
        List list = Lists.newArrayList(o);
        System.out.println(list);
    }

    @Test
    public void test() {
        Long l1 = 1L;

        ttt(l1);
    }

    public static void ttt(Long ... longs) {
        System.out.println(longs[0]);
        System.out.println(longs);
    }

//    @Test
//    public void testInput(Long l) {
//        System.out.println(l);
//    }

}
