package com.example.myspring.service;

import com.example.myspring.pojo.CompanyOrganization;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/27 7:23 PM
 */
public interface CompanyOrganizationService {

    List<CompanyOrganization> getHeaderOrgs();

    List<CompanyOrganization> getOrgsById(Long id);

    List<CompanyOrganization> getOrgsBy(Long id);
}
