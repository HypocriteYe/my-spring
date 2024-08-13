package com.example.myspring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myspring.mapper.UsersMapper;
import com.example.myspring.pojo.Users;
import com.example.myspring.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 11:39
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public int insertBatchSomeColumn(Collection<Users> users) {
        return usersMapper.insertBatchSomeColumn(users);
    }
}
