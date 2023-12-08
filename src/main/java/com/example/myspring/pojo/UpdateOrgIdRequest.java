package com.example.myspring.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2023/11/1 3:17 PM
 */
@Data
@Builder
public class UpdateOrgIdRequest {

    private List<Long> tenantIds;

    private Integer type;
}
