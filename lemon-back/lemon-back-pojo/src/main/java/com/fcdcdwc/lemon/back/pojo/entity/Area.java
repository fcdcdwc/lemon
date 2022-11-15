package com.fcdcdwc.lemon.back.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 中国行政区划表
 * @TableName area
 */
@TableName(value ="area")
@Data
public class Area implements Serializable {
    /**
     * 地域编码
     */
    @TableId
    private String id;

    /**
     * 地域名称
     */
    private String name;

    /**
     * 上级地域编码
     */
    private String parentId;

    /**
     * 地址
     */
    private String abbr;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 是否为叶子
     */
    private Boolean isleaf;

    /**
     * 业务使用的父级ID
     */
    private String parentRealId;

    /**
     * 经度
     */
    private BigDecimal lng;

    /**
     * 维度
     */
    private BigDecimal lat;

    @TableField(exist = false)
    private List<Area> children = new ArrayList<>();


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Area other = (Area) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getAbbr() == null ? other.getAbbr() == null : this.getAbbr().equals(other.getAbbr()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getIsleaf() == null ? other.getIsleaf() == null : this.getIsleaf().equals(other.getIsleaf()))
            && (this.getParentRealId() == null ? other.getParentRealId() == null : this.getParentRealId().equals(other.getParentRealId()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getAbbr() == null) ? 0 : getAbbr().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getIsleaf() == null) ? 0 : getIsleaf().hashCode());
        result = prime * result + ((getParentRealId() == null) ? 0 : getParentRealId().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", abbr=").append(abbr);
        sb.append(", level=").append(level);
        sb.append(", isleaf=").append(isleaf);
        sb.append(", parentRealId=").append(parentRealId);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append("]");
        return sb.toString();
    }
}