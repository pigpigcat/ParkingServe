package com.github.core.domain;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class User {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userId;

    private String password;

    private Boolean enabled;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModified=" + gmtModified)
                .add("userId='" + userId + "'")
                .add("password='" + password + "'")
                .add("enabled=" + enabled)
                .toString();
    }
}