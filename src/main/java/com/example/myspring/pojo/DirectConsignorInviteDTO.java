package com.example.myspring.pojo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.checkerframework.checker.units.qual.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DirectConsignorInviteDTO {
    @Data
    @ApiModel("添加直客货主邀请")
    public static class Add implements Serializable {
        private static final long serialVersionUID = -8784462222086384085L;

        @ApiModelProperty("推荐人")
        @NotBlank(message = "推荐人必填")
//        @Length(max = 50, message = "推荐人信息过长")
        private String inviter;

    }


    @Data
    @ApiModel("查询直客货主邀请")
    public static class Query implements Serializable {
        private static final long serialVersionUID = 7041445831394588456L;

        @ApiModelProperty("主键ID")
        private Long id;

        @ApiModelProperty("推荐人")
        private String inviter;

        @ApiModelProperty("分页大小")
        private long pageSize;

        @ApiModelProperty("页数")
        private long pageNum;

        @ApiModelProperty("排序")
        private List<OrderItem> orders;
    }

    @Data
    @ApiModel("直客货主邀请返回信息")
    public static class Result implements Serializable {
        private static final long serialVersionUID = 7441146138334955620L;

        @ApiModelProperty("主键ID")
        private Long id;

        @ApiModelProperty("推荐人")
        private String inviter;

        @ApiModelProperty("直客货主带参链接")
        private String directConsignorInviteUrl;

        @ApiModelProperty("创建时间")
        private Date createTime;

        @ApiModelProperty("创建人id")
        private Long creatorId;

        @ApiModelProperty("最近修改时间")
        private Date lastUpdateTime;

        @ApiModelProperty("更新人id")
        private Long lastUpdaterId;
    }
}