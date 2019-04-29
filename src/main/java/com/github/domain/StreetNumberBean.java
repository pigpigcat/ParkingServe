package com.github.domain;

import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class StreetNumberBean {

    private String number;
    private String location;
    private String direction;
    private String distance;
    private String street;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StreetNumberBean.class.getSimpleName() + "[", "]")
                .add("number='" + number + "'")
                .add("location='" + location + "'")
                .add("direction='" + direction + "'")
                .add("distance='" + distance + "'")
                .add("street='" + street + "'")
                .toString();
    }
}