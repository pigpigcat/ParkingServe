package com.github.domain;

import java.util.List;

/**
 * @author wulitech
 */
public class AMap {
    /**
     * status : 1
     * count : 900
     * info : OK
     * infocode : 10000
     * suggestion : {"keywords":[],"cities":[]}
     * pois : [{"id":"B0FFG8BX05","parent":"B00160E40E","name":"三轻楼地上停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾馆西路18号附近","location":"117.199722,39.084060","tel":[],"distance":"109","biz_ext":{"rating":"3.0","cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFHGLKOG","parent":"B00160EC9J","name":"天津市人民政府地面停车场","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口东南50米","location":"117.200725,39.083156","tel":[],"distance":"113","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFGXZZKU","parent":[],"name":"停车场(欧亚花园东北)","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口西50米","location":"117.200109,39.083304","tel":[],"distance":"121","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFHGLKTE","parent":[],"name":"宾馆西路-占道停车场","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口东南100米","location":"117.201134,39.082956","tel":[],"distance":"134","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG18LWZ","parent":"B0016067Z2","name":"天成公寓停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾馆西路","location":"117.201923,39.082902","tel":[],"distance":"161","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFH5E622","parent":"B00160ECJK","name":"欧亚花园停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"紫金山路与宾水道交汇处南侧欧亚花园","location":"117.199424,39.083251","tel":[],"distance":"168","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG18LO2","parent":"B001607UEG","name":"天宾公寓停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾馆西路","location":"117.201070,39.082552","tel":[],"distance":"178","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B00160DWD3","parent":[],"name":"停车场(天成公寓西北)","type":"交通设施服务;停车场;公共停车场|交通设施服务;停车场;路边停车场","typecode":"150904|150906","biz_type":[],"address":"宾馆西路5号附近","location":"117.201583,39.082478","tel":[],"distance":"194","biz_ext":{"rating":[],"cost":[]},"pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[{"url":"http://store.is.autonavi.com/showpic/791a76fa43859184fd0d5bddd8f2f93a","title":[],"provider":[]}]},{"id":"B0FFHGLL9R","parent":[],"name":"停车场(叠彩道)","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口西南150米","location":"117.199374,39.082853","tel":[],"distance":"201","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG6BBC0","parent":[],"name":"停车场(美印楼西北)","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口东南150米","location":"117.201463,39.082309","tel":[],"distance":"209","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFGJ1N0G","parent":"B001605XXP","name":"天津利和集团停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾水道增9号上海浦东发展银行天津分行","location":"117.197647,39.084678","tel":[],"distance":"294","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFGIQ9K9","parent":[],"name":"叠彩道停车场","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"西园道17文苑楼北1门附近","location":"117.198270,39.082269","tel":[],"distance":"314","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG7U1U3","parent":[],"name":"凯德龙园大酒店沿街停车场","type":"交通设施服务;停车场;停车场相关","typecode":"150900","biz_type":[],"address":"宾水道9号","location":"117.197216,39.084506","tel":[],"distance":"327","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B00161604N","parent":[],"name":"停车场(叠彩道)","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"西园道17文苑楼北1门附近","location":"117.198062,39.082279","tel":[],"distance":"327","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B00160DPQ1","parent":"B00160A6K5","name":"环渤海发展中心停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾水道增9号环渤海发展中心","location":"117.197124,39.083777","tel":[],"distance":"336","biz_ext":{"rating":"3.0","cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[{"url":"http://store.is.autonavi.com/showpic/84d892d545aae8fe9c388f62034fe054","title":[],"provider":[]},{"url":"http://store.is.autonavi.com/showpic/f5f2e73c016711afd3341d72feff4acc","title":[],"provider":[]},{"url":"http://store.is.autonavi.com/showpic/141a1f3ab03a9715be8c78ca9928fafa","title":[],"provider":[]}]},{"id":"B0FFFA8HMZ","parent":"B0FFF01AKX","name":"上海浦东发展银行停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾水道增9号上海浦东发展银行天津分行","location":"117.196983,39.084333","tel":[],"distance":"346","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFINP4WT","parent":"B0FFK4TQQL","name":"鹏聚楼大酒店地上停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾馆南道与宾馆西路交叉口西100米","location":"117.201651,39.080972","tel":[],"distance":"359","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG1ACOD","parent":"B001619CC8","name":"军民小区停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾馆南道军民小区","location":"117.200764,39.080807","tel":[],"distance":"373","biz_ext":{"rating":[],"cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFFA8HMY","parent":"B0FFG0X0OB","name":"天津宾馆停车场","type":"交通设施服务;停车场;公共停车场","typecode":"150904","biz_type":[],"address":"宾水道16号万丽天津宾馆","location":"117.196539,39.084079","tel":[],"distance":"384","biz_ext":{"rating":"3.0","cost":[]},"parking_type":"地面","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]},{"id":"B0FFG6BBC6","parent":[],"name":"停车场(军民小区西)","type":"交通设施服务;停车场;路边停车场","typecode":"150906","biz_type":[],"address":"叠彩道与宾馆西路交叉口东南100米","location":"117.200814,39.080645","tel":[],"distance":"391","biz_ext":{"rating":[],"cost":[]},"parking_type":"路边","pname":"天津市","cityname":"天津市","adname":"河西区","importance":[],"shopid":[],"shopinfo":"2","poiweight":[],"photos":[]}]
     */

    private String status;
    private String count;
    private String info;
    private String infocode;
    private SuggestionBean suggestion;
    private List<PoisBean> pois;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
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

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<PoisBean> getPois() {
        return pois;
    }

    public void setPois(List<PoisBean> pois) {
        this.pois = pois;
    }

    public static class SuggestionBean {
        private List<?> keywords;
        private List<?> cities;

        public List<?> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<?> keywords) {
            this.keywords = keywords;
        }

        public List<?> getCities() {
            return cities;
        }

        public void setCities(List<?> cities) {
            this.cities = cities;
        }
    }
}
