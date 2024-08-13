package com.example.myspring.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @Author ygl
 * @Create 2024/7/5 11:37
 */
@Builder
@Data
@TableName("users")
public class Users implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userid;
    private Integer departmentId;
}
