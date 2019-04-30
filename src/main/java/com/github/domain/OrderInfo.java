package com.github.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo implements Serializable {
    private Integer orderId;

    private Date gmtCreate;

    private Date gmtPay;

    private String userId;

    private String parkingName;

    private String parkingId;

    private Boolean parkingPlace;

    private String price;

    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtPay() {
        return gmtPay;
    }

    public void setGmtPay(Date gmtPay) {
        this.gmtPay = gmtPay;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName == null ? null : parkingName.trim();
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId == null ? null : parkingId.trim();
    }

    public Boolean getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(Boolean parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtPay=").append(gmtPay);
        sb.append(", userId=").append(userId);
        sb.append(", parkingName=").append(parkingName);
        sb.append(", parkingId=").append(parkingId);
        sb.append(", parkingPlace=").append(parkingPlace);
        sb.append(", price=").append(price);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}