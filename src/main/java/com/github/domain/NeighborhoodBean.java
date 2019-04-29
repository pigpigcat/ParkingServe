package com.github.domain;

import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class NeighborhoodBean {

    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NeighborhoodBean.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .toString();
    }
}