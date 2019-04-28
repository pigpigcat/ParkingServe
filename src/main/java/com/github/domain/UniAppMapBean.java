package com.github.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class UniAppMapBean {
    /**
     * 中心经度
     */
    private String longitude;
    /**
     * 中心纬度
     */
    private String latitude;
    /**
     * 缩放级别，取值范围为5-18
     */
    private String scale;
    /**
     * 标记点
     */
    private List<Marker> markers;

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

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UniAppMapBean.class.getSimpleName() + "[", "]")
                .add("longitude='" + longitude + "'")
                .add("latitude='" + latitude + "'")
                .add("scale='" + scale + "'")
                .add("markers=" + markers)
                .toString();
    }
}
