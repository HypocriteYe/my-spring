package com.example.myspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myspring.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 11:38
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    int insertBatchSomeColumn(Collection<Users> users);
}
