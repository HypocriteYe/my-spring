package com.example.myspring.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @description
 * @Author ygl
 * @Create 2023/10/27 7:22 PM
 */
@Data
@Builder
public class CompanyOrganization {

    private Long id;
    /**
     * 平台
     */
    private Long platformId;
    /**
     * 企业
     */
    private Long companyId;
    /**
     * 上级机构
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;

    /**
     * 当前用户数
     */
    private Integer userCount;

    /**
     * 启用：0否｜1是
     */
    private Integer enable;

    /**
     * 层级：0总部|1一级|2二级
     */
    private Integer level;

    /**
     * 子机构数量
     */
    private Integer subCount;

    /**
     * 备注
     */
    private String remark;

    private Integer deleted;
}
