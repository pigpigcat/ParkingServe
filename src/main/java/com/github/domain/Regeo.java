package com.github.domain;


import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class Regeo {

    private String status;
    private RegeocodeBean regeocode;
    private String info;
    private String infocode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegeocodeBean getRegeocode() {
        return regeocode;
    }

    public void setRegeocode(RegeocodeBean regeocode) {
        this.regeocode = regeocode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Regeo.class.getSimpleName() + "[", "]")
                .add("status='" + status + "'")
                .add("regeocode=" + regeocode)
                .add("info='" + info + "'")
                .add("infocode='" + infocode + "'")
                .toString();
    }
}
