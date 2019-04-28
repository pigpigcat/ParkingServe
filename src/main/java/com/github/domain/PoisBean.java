package com.github.domain;

import java.util.List;

/**
 * @author wulitech
 */
public class PoisBean {
    /**
     * id : B0FFG8BX05
     * parent : B00160E40E
     * name : 三轻楼地上停车场
     * type : 交通设施服务;停车场;公共停车场
     * typecode : 150904
     * biz_type : []
     * address : 宾馆西路18号附近
     * location : 117.199722,39.084060
     * tel : []
     * distance : 109
     * biz_ext : {"rating":"3.0","cost":[]}
     * parking_type : 地面
     * pname : 天津市
     * cityname : 天津市
     * adname : 河西区
     * importance : []
     * shopid : []
     * shopinfo : 2
     * poiweight : []
     * photos : []
     */

    private String id;
    private String parent;
    private String name;
    private String type;
    private String typecode;
    private String address;
    private String location;
    private String distance;
    private BizExtBean biz_ext;
    private String parking_type;
    private String pname;
    private String cityname;
    private String adname;
    private String shopinfo;
    private List<?> biz_type;
    private List<?> tel;
    private List<?> importance;
    private List<?> shopid;
    private List<?> poiweight;
    private List<?> photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

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

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public BizExtBean getBiz_ext() {
        return biz_ext;
    }

    public void setBiz_ext(BizExtBean biz_ext) {
        this.biz_ext = biz_ext;
    }

    public String getParking_type() {
        return parking_type;
    }

    public void setParking_type(String parking_type) {
        this.parking_type = parking_type;
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

    public String getShopinfo() {
        return shopinfo;
    }

    public void setShopinfo(String shopinfo) {
        this.shopinfo = shopinfo;
    }

    public List<?> getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(List<?> biz_type) {
        this.biz_type = biz_type;
    }

    public List<?> getTel() {
        return tel;
    }

    public void setTel(List<?> tel) {
        this.tel = tel;
    }

    public List<?> getImportance() {
        return importance;
    }

    public void setImportance(List<?> importance) {
        this.importance = importance;
    }

    public List<?> getShopid() {
        return shopid;
    }

    public void setShopid(List<?> shopid) {
        this.shopid = shopid;
    }

    public List<?> getPoiweight() {
        return poiweight;
    }

    public void setPoiweight(List<?> poiweight) {
        this.poiweight = poiweight;
    }

    public List<?> getPhotos() {
        return photos;
    }

    public void setPhotos(List<?> photos) {
        this.photos = photos;
    }

    public static class BizExtBean {
        /**
         * rating : 3.0
         * cost : []
         */

        private String rating;
        private List<?> cost;

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public List<?> getCost() {
            return cost;
        }

        public void setCost(List<?> cost) {
            this.cost = cost;
        }
    }
}
