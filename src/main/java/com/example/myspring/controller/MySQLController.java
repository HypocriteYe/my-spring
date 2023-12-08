package com.example.myspring.controller;

import com.example.myspring.pojo.AgentInfo;
import com.example.myspring.pojo.CompanyOrganization;
import com.example.myspring.service.AgentInfoService;
import com.example.myspring.service.CompanyOrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/27 7:21 PM
 */
@RestController
@Slf4j
public class MySQLController {

    @Autowired
    private CompanyOrganizationService companyOrganizationService;

    @Autowired
    private AgentInfoService agentInfoService;

    @GetMapping("/updateNull")
    public int updateNull() {
        AgentInfo agentInfo = new AgentInfo();
        agentInfo.setId(123L);
        agentInfo.setInviter(null);
        agentInfo.setInviterId(null);
        agentInfo.setInviteSource(null);
        return agentInfoService.update(agentInfo);
    }

    @GetMapping("/getOrgsById")
    public String getOrgsById(Long id) {

        List<CompanyOrganization> companyOrganizations = companyOrganizationService.getOrgsById(id);
        return companyOrganizations.toString();
    }

    @GetMapping("/getOrgsBy")
    public String getOrgsBy(Long id) {

        List<CompanyOrganization> companyOrganizations = companyOrganizationService.getOrgsBy(id);
        return companyOrganizations.toString();
    }

    @GetMapping("/getOrgs")
    public String getOrgs() {

        List<CompanyOrganization> orgs = companyOrganizationService.getHeaderOrgs();
//        orgs.forEach(System.out::println);
//        log.info("list.size：{}", orgs.size());
        long start = System.currentTimeMillis();
        Map<Long, Long> map = orgs.stream().collect(Collectors.toMap(CompanyOrganization::getCompanyId, CompanyOrganization::getId, (o,n) -> n));

//        HashMap<Long, Long> map = new HashMap<>();
//        for (CompanyOrganization org : orgs) {
//            Long aLong = map.get(org.getCompanyId());
//            if (Objects.nonNull(aLong)) {
//                log.info("===============出现冲突的key：{},{}", aLong, org);
//            }
//            map.put(org.getCompanyId(), org.getId());
//        }
        long end = System.currentTimeMillis();
        log.info("map.size：{},takes：{}", map.size(), end - start);
        return "ok";
    }

    @GetMapping("/test")
    public String test() {

        List<CompanyOrganization> orgs = companyOrganizationService.getHeaderOrgs();

        long start = System.currentTimeMillis();


        HashMap<Long, Long> map = new HashMap<>();
        for (CompanyOrganization org : orgs) {
            map.put(org.getCompanyId(), org.getId());
        }
        long end = System.currentTimeMillis();
        log.info("map.size：{},takes：{}", map.size(), end - start);
        return "ok";
    }

    @GetMapping("/testOrgs")
    public String testOrgs() {

        List<CompanyOrganization> list = new ArrayList<>();
        list.add(CompanyOrganization.builder().id(133L).companyId(105L).build());
        list.add(CompanyOrganization.builder().id(132L).companyId(105L).build());
        Map<Long, Long> collect = list.stream().collect(Collectors.toMap(CompanyOrganization::getCompanyId, CompanyOrganization::getId));
        log.info("map：{}", collect);
        return "ok";
    }


    private static Executor executor = new ThreadPoolExecutor(4, 10, 50L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10000));
//    @PostMapping("/open/updateOrgIdSpec")
//    public void updateOrgIdSpec(@RequestBody UpdateOrgIdRequest request) {
//        List<Long> tenantIds = request.getTenantIds();
//        if (CollectionUtils.isEmpty(tenantIds)) {
//            List<TenantInfo> tenants = tenantInfoProvider.listByCondition(new TenantListDTO());
//            tenantIds = tenants.stream().map(TenantInfoDTO::getId).collect(Collectors.toList());
//        }
//        List<CompletableFuture<Void>> futures = new ArrayList<>();
//        tenantIds.forEach(tenantId -> {
//                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//                        List<CompanyOrganization> headerOrgs = companyOrganizationProvider.getHeaderOrgs();
//                        Map<Long, Long> companyIdOrgIdMap = headerOrgs.stream().collect(Collectors.toMap(CompanyOrganization::getCompanyId, CompanyOrganization::getId, (oldRecord,newRecord) ->oldRecord));
//
//                        companyIdOrgIdMap.forEach((companyId, OrgId) -> {
//                            switch (request.getType()) {
//                                case 1:
//                                    customerService.updateOrgId(tenantId, companyId, OrgId);
//                                    break;
//                                case 2:
//                                    customerContractService.updateOrgId(tenantId, companyId, OrgId);
//                                    break;
//                                case 3:
//                                    chargeRuleService.updateOrgId(tenantId, companyId, OrgId);
//                                    break;
//                            }
//                        }, executor);
//
//                    }).whenComplete((result, exception) -> {
//                        if (exception!= null) {
//                            log.error("exception：{}", exception.getMessage());
//                        }
//                    }));
//                    futures.add(future);
//                }
//        );
//        CompletableFuture[] array = futures.toArray(new CompletableFuture[0]);
//        List<Long> finalTenantIds = tenantIds;
//        CompletableFuture.allOf(array).whenComplete((result, exception) -> {
//        });
//    }
}
