package com.github.domain;

import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class Label {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Label.class.getSimpleName() + "[", "]")
                .add("content='" + content + "'")
                .toString();
    }
}
