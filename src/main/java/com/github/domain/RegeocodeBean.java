package com.github.domain;


import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class RegeocodeBean {

    private AddressComponentBean addressComponent;
    private String formatted_address;

    public AddressComponentBean getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(AddressComponentBean addressComponent) {
        this.addressComponent = addressComponent;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegeocodeBean.class.getSimpleName() + "[", "]")
                .add("addressComponent=" + addressComponent)
                .add("formatted_address='" + formatted_address + "'")
                .toString();
    }
}