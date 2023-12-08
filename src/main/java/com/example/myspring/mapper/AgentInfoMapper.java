package com.example.myspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myspring.pojo.AgentInfo;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
 * @description
 * @Author ygl
 * @Create 2023/12/1 11:30 AM
 */
@Mapper
public interface AgentInfoMapper extends BaseMapper<AgentInfo> {
}
