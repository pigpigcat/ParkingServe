package com.github.core.domain;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author wulitech
 * @version 1.0
 */
public class UserRole {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userId;

    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserRole.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModified=" + gmtModified)
                .add("userId='" + userId + "'")
                .add("authority='" + authority + "'")
                .toString();
    }
}