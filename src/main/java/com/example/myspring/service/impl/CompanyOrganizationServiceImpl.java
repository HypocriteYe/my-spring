package com.example.myspring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.myspring.mapper.CompanyOrganizationMapper;
import com.example.myspring.pojo.CompanyOrganization;
import com.example.myspring.service.CompanyOrganizationService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/27 7:24 PM
 */
@Service
public class CompanyOrganizationServiceImpl implements CompanyOrganizationService {

    @Autowired
    CompanyOrganizationMapper companyOrganizationMapper;


    @Override
    public List<CompanyOrganization> getHeaderOrgs() {
        LambdaQueryWrapper<CompanyOrganization> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CompanyOrganization::getParentId, 0)
                .eq(CompanyOrganization::getDeleted, 0);
        return companyOrganizationMapper.selectList(wrapper);
    }

    @Override
    public List<CompanyOrganization> getOrgsById(Long id) {
        List list = Lists.newArrayList(id);
        LambdaQueryWrapper<CompanyOrganization> wrapper = new LambdaQueryWrapper<>();
        List<Long> visibleIds = getChildrenId(id);
        list.add(visibleIds);
        wrapper.in(CompanyOrganization::getId, list);
        return companyOrganizationMapper.selectList(wrapper);
    }

    @Override
    public List<CompanyOrganization> getOrgsBy(Long id) {
        List list = Lists.newArrayList();
        list = null;
        LambdaQueryWrapper<CompanyOrganization> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(CompanyOrganization::getId, list);
        return companyOrganizationMapper.selectList(wrapper);
    }

    public List<Long> getChildrenId(Long parentId) {
        if (parentId == null) {
            return new ArrayList<>();
        }

        List<Long> allChildrenId = new ArrayList<>();
        List<Long> parentIds = Lists.newArrayList(parentId);

        // 支持的机构级数，目前是3级
        int openLevel = 3;

        for (int i = 1; i < openLevel; i++) {
            parentIds = getChildren(parentIds);
            if (CollectionUtils.isEmpty(parentIds)) {
                break;
            }
            allChildrenId.addAll(parentIds);
        }
        return allChildrenId;
    }

    private List<Long> getChildren(List<Long> parents) {
        if (CollectionUtils.isEmpty(parents)) {
            return new ArrayList<>();
        }
        LambdaQueryWrapper<CompanyOrganization> query = Wrappers.lambdaQuery(CompanyOrganization.class)
                .in(CompanyOrganization::getParentId, parents)
                .eq(CompanyOrganization::getDeleted, 0);

        List<CompanyOrganization> orgs = companyOrganizationMapper.selectList(query);
        if (CollectionUtils.isEmpty(orgs)) {
            return new ArrayList<>();
        }
        return orgs.stream().map(CompanyOrganization::getId).collect(Collectors.toList());
    }
}
