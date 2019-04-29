package com.github.util;

import com.alibaba.fastjson.JSON;
import com.github.domain.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * 高德地图API
 *
 * @author wulitech
 */
public class AMapUtils {

    private static final String URL_PREFIX = "https://restapi.amap.com";
    private static final String KEY = "a8688bbe69137c037bfa8b351cb0ef11";
    private static final String KEY_WORDS = "停车场";
    private static final String TYPES = "停车场相关";
    private static final String CITY_LIMIT = "true";

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }

    private static Regeo poiRegeo(String location) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX + "/v3/geocode/regeo?location="
                + location + "&key=" + KEY, String.class);
        String body = responseEntity.getBody();
        return JSON.parseObject(body, Regeo.class);
    }

    public static List<Marker> poiAround(String location) {
        Regeo regeo = poiRegeo(location);
        AddressComponentBean addressComponentBean = regeo.getRegeocode().getAddressComponent();
        // 行政区code
        String adcode = addressComponentBean.getAdcode();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX + "/v3/place/around?keywords="
                + KEY_WORDS + "&key=" + KEY + "&types=" + TYPES + "&city=" + adcode + "&=citylimit" + CITY_LIMIT + "&location=" + location, String.class);
        String body = responseEntity.getBody();
        AMap aMap = JSON.parseObject(body, AMap.class);
        List<PoisBean> poisBeans = Objects.requireNonNull(aMap).getPois();
        List<Marker> markerList = new ArrayList<>();
        markerListAdapter(poisBeans, markerList);
        return markerList;
    }

    private static void markerListAdapter(List<PoisBean> poisBeans, List<Marker> markerList) {
        for (PoisBean poisBean : poisBeans) {
            Marker marker = new Marker();
            marker.setId(poisBean.getId());
            Label label = new Label();
            label.setContent(poisBean.getName());
            marker.setLabel(label);
            String[] split = poisBean.getLocation().split(",");
            marker.setLongitude(split[0]);
            marker.setLatitude(split[1]);
            markerList.add(marker);
        }
    }
}
