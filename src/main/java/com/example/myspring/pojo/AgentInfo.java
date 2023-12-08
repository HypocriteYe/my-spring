package com.example.myspring.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.util.Date;

//@Builder
@Data
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
@TableName("agent_info")
public class AgentInfo extends BasePO {
    /**
     * 绑定登陆账户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 唯一编码，主要用于分享邀请
     */
    private String code;

    /**
     * 代理人类型
     *
     */
    @TableField("type")
    private Integer type;

    /**
     * 代理人子类型
     *
     */
    @TableField("sub_type")
    private Integer subType;

    @TableField("level")
    private Integer level;

    /**
     * 企业简称
     */
//    @Column(name = "short_name")
    private String shortName;

    /**
     * 代理人姓名/企业名称
     */
    private String name;

    /**
     * 身份证号码/企业信用代码
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 身份证地址
     */
    private String address;

    /**
     * 企业详细地址
     */
    @TableField("location")
    private String location;

    /**
     * 法人姓名
     */
    @TableField("legal_name")
    private String legalName;

    /**
     * 法人身份证号
     */
    @TableField("legal_id_card")
    private String legalIdCard;

    /**
     * 联系电话
     */
    @TableField("contact_phone")
    private String contactPhone;

    /**
     * 推荐人
     */
    @TableField(value = "inviter", updateStrategy = FieldStrategy.IGNORED)
    private String inviter;

    /**
     * 推荐人ID，代理人邀请码表的ID
     *
     */
    @TableField("inviter_id")
    private Long inviterId;

    /**
     * 推荐人来源
     *
     */
    @TableField("invite_source")
    private Integer inviteSource;

    /**
     * 所属公司，仅个人代理人
     */
    @TableField("company")
    private String company;

    /**
     * 审核状态
     *
     */
    @TableField("review_state")
    private Integer reviewState;

    /**
     * 审核备注
     */
    @TableField("review_remark")
    private String reviewRemark;

    /**
     * 审核人ID
     */
    @TableField("reviewer_id")
    private Long reviewerId;

    /**
     * 审核人
     */
    @TableField("reviewer")
    private String reviewer;

    /**
     * 拒绝理由
     */
    @TableField("refuse_reason")
    private String refuseReason;

    /**
     * 审核时间/入驻时间
     */
    @TableField("review_date")
    private Date reviewDate;

    /**
     * 生效日期
     */
    @TableField("effective_date")
    private Date effectiveDate;

    /**
     * 失效日期
     */
    @TableField("expiration_date")
    private Date expirationDate;

    /**
     * 申请时间
     */
    @TableField("application_date")
    private Date applicationDate;

    /**
     * 身份证签发机关
     */
    @TableField("id_card_issue_organization")
    private String idCardIssueOrganization;

    /**
     * 身份证生效日期
     */
    @TableField("id_card_start_date")
    private Date idCardStartDate;

    /**
     * 身份证失效日期
     */
    @TableField("id_card_end_date")
    private Date idCardEndDate;

    /**
     * 身份证正面照
     */
    @TableField("id_card_front_filename")
    private String idCardFrontFilename;

    /**
     * 身份证背面
     */
    @TableField("id_card_back_filename")
    private String idCardBackFilename;

    /**
     * 营业执照照片文件名
     */
    @TableField("business_license_filename")
    private String businessLicenseFilename;

    /**
     * 收款人证件号
     */
    @TableField("payee_id_card")
    private String payeeIdCard;

    /**
     * 收款人名称
     */
    @TableField("payee_name")
    private String payeeName;

    /**
     * 收款人账户号码
     */
    @TableField("payee_account_no")
    private String payeeAccountNo;

    /**
     * 收款人开户银行/收款渠道
     */
    @TableField("payee_bank_deposit")
    private String payeeBankDeposit;

    /**
     * 收款人开户支行
     */
    @TableField("payee_bank_branch_name")
    private String payeeBankBranchName;

    /**
     * 增值账户开户状态：0-未开户 10-开户成功 20-开户失败
     */
    @TableField("gaea_account_state")
    private Integer gaeaAccountState;

    /**
     * 增值开户异常信息
     */
    @TableField("gaea_account_msg")
    private String gaeaAccountMsg;

    /**
     * 支付账号
     */
    @TableField("trade_account_no")
    private String tradeAccountNo;

    /**
     * 支付开户状态
     *
     */
    @TableField("trade_account_state")
    private Integer tradeAccountState;

    /**
     * 支付开户异常信息
     */
    @TableField("trade_account_msg")
    private String tradeAccountMsg;

    @TableField("app_id")
    private String appId;

    @TableField("secret_key")
    private String secretKey;

    @TableField("callback_url")
    private String callbackUrl;

    /**
     * 开启加盟服务开关 1-开启 0-关闭
     */
    @TableField("franchise_biz_switch")
    private Integer franchiseBizSwitch;

    /**
     * 开启货代服务开关 1-开启 0-关闭
     */
    @TableField("agent_biz_switch")
    private Integer agentBizSwitch;

    /**
     * 代理人注册类型，0-普通代理人，1-专属代理人
     *
     */
    @TableField("registry_type")
    private Integer registryType;

    @TableField("platform_id")
    private Long platformId;
}