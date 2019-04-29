package com.github.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author wulitech
 */
public class AddressComponentBean {

    private String province;
    private String adcode;
    private String district;
    private String towncode;
    private StreetNumberBean streetNumber;
    private String country;
    private String township;
    private BuildingBean building;
    private NeighborhoodBean neighborhood;
    private String citycode;
    private List<?> city;
    private List<BusinessAreasBean> businessAreas;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTowncode() {
        return towncode;
    }

    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    public StreetNumberBean getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(StreetNumberBean streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public BuildingBean getBuilding() {
        return building;
    }

    public void setBuilding(BuildingBean building) {
        this.building = building;
    }

    public NeighborhoodBean getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodBean neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public List<?> getCity() {
        return city;
    }

    public void setCity(List<?> city) {
        this.city = city;
    }

    public List<BusinessAreasBean> getBusinessAreas() {
        return businessAreas;
    }

    public void setBusinessAreas(List<BusinessAreasBean> businessAreas) {
        this.businessAreas = businessAreas;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressComponentBean.class.getSimpleName() + "[", "]")
                .add("province='" + province + "'")
                .add("adcode='" + adcode + "'")
                .add("district='" + district + "'")
                .add("towncode='" + towncode + "'")
                .add("streetNumber=" + streetNumber)
                .add("country='" + country + "'")
                .add("township='" + township + "'")
                .add("building=" + building)
                .add("neighborhood=" + neighborhood)
                .add("citycode='" + citycode + "'")
                .add("city=" + city)
                .add("businessAreas=" + businessAreas)
                .toString();
    }
}