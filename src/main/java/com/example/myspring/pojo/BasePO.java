package com.example.myspring.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author tuwenzhi
 * @title: BaseModel
 * @projectName wlhyos-supervision
 * @description: 基础po
 * @date 2020-12-03 11:24
 */
public class BasePO {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
//    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
//    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 最近修改时间
     */
//    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 更新人id
     */
//    @Column(name = "last_updater_id")
    private Long lastUpdaterId;

    /**
     * 删除状态，0-未删除，1-已删除
     */
    private Integer deleted;

    public static <T extends BasePO> T getInit(Long userId, Class<T> type) {
        try {
            Date date = new Date();
            T po = type.newInstance();
            po.setDeleted(0);
            po.setCreateTime(date);
            po.setLastUpdateTime(date);
            po.setCreatorId(userId);
            po.setLastUpdaterId(userId);
            return po;
        } catch (Exception e) {
//            throw new BizException("SUP001", "类型转化失败");
            throw new RuntimeException();
        }
    }

    public void fillCreateInit(Long userId) {
        Date date = new Date();
        this.createTime = date;
        this.lastUpdateTime = date;
        this.creatorId = userId;
        this.lastUpdaterId = userId;
        this.deleted = 0;
    }

    public void fillUpdateInit(Long userId) {
        this.lastUpdateTime = new Date();
        this.lastUpdaterId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getLastUpdaterId() {
        return lastUpdaterId;
    }

    public void setLastUpdaterId(Long lastUpdaterId) {
        this.lastUpdaterId = lastUpdaterId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
