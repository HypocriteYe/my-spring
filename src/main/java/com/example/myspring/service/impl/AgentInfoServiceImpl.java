package com.example.myspring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.myspring.mapper.AgentInfoMapper;
import com.example.myspring.pojo.AgentInfo;
import com.example.myspring.service.AgentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description
 * @Author ygl
 * @Create 2023/12/1 11:29 AM
 */
@Service
public class AgentInfoServiceImpl implements AgentInfoService {

    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Override
    public int update(AgentInfo agentInfo) {
        agentInfo.setLastUpdateTime(new Date());
        LambdaUpdateWrapper<AgentInfo> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(AgentInfo::getId, agentInfo.getId());
        return agentInfoMapper.update(agentInfo, wrapper);
    }
}
