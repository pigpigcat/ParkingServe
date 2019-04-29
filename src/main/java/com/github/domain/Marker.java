package com.github.domain;

import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class Marker {
    /**
     * 标记点id
     */
    private String id;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 显示的图标
     */
    private String iconPath;
    /**
     * 为标记点旁边增加标签
     */
    private Label label;

    private String address;

    private String pname;

    private String cityname;

    private String adname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public Marker() {
        iconPath = "/static/app-plus/location@3x.png";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Marker.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("longitude='" + longitude + "'")
                .add("latitude='" + latitude + "'")
                .add("iconPath='" + iconPath + "'")
                .add("label=" + label)
                .add("address='" + address + "'")
                .add("pname='" + pname + "'")
                .add("cityname='" + cityname + "'")
                .add("adname='" + adname + "'")
                .toString();
    }
}
