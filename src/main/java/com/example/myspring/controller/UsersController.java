package com.example.myspring.controller;

import com.alibaba.fastjson.JSON;
import com.example.myspring.mapper.UsersMapper;
import com.example.myspring.pojo.Users;
import com.example.myspring.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 11:49
 */
@RestController
@Slf4j
public class UsersController {

    @Resource
    private UsersService usersService;

    private static Random random = new Random();

    @GetMapping("/batchSave")
    public boolean batchSave() {
        List<Users> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String userid = UUID.randomUUID().toString().substring(0, 5);
            Users users = Users.builder().userid(userid).departmentId(random.nextInt(100)).build();
            log.info("user[{}]: {}", i, JSON.toJSONString(users));
            list.add(users);
        }
        return usersService.saveBatch(list);
    }

    @GetMapping("/batchSaveSome")
    public int batchSaveSome() {
        List<Users> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String userid = UUID.randomUUID().toString().substring(0, 5);
            Users users = Users.builder().userid(userid).departmentId(random.nextInt(100)).build();
            log.info("user[{}]: {}", i, JSON.toJSONString(users));
            list.add(users);
        }
        return usersService.insertBatchSomeColumn(list);
    }
}
