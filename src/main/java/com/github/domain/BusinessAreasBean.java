package com.github.domain;

import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class BusinessAreasBean {

    private String location;
    private String name;
    private String id;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BusinessAreasBean.class.getSimpleName() + "[", "]")
                .add("location='" + location + "'")
                .add("name='" + name + "'")
                .add("id='" + id + "'")
                .toString();
    }
}