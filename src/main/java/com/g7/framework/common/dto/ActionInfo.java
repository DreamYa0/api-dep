package com.g7.framework.common.dto;

import java.io.Serializable;

/**
 * @author dreamyao
 * @title
 * @date 2018/8/25 下午12:04
 * @since 1.0.0
 */
public class ActionInfo implements Serializable {

    /**
     * 来源产品 ntocc、weever
     */
    private Integer fromProduction;

    /**
     * 来源站点：
     * 1：WEB 2：APP
     */
    private Integer sourceSite;

    /**
     * 手机终端类型：1：安卓 2：IOS
     */
    private Byte phoneType;

    /**
     * 调用来源ip
     */
    private String sourceIp;

    /**
     * 操作人用户ID
     */
    private Integer userId;

    /**
     * 操作人昵称
     */
    private String nickname;

    public Integer getFromProduction() {
        return fromProduction;
    }

    public void setFromProduction(Integer fromProduction) {
        this.fromProduction = fromProduction;
    }

    public Integer getSourceSite() {
        return sourceSite;
    }

    public void setSourceSite(Integer sourceSite) {
        this.sourceSite = sourceSite;
    }

    public Byte getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Byte phoneType) {
        this.phoneType = phoneType;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
