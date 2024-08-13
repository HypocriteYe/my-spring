package com.example.myspring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myspring.pojo.Users;

import java.util.Collection;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 11:38
 */
public interface UsersService extends IService<Users> {

    int insertBatchSomeColumn(Collection<Users> users);
}
