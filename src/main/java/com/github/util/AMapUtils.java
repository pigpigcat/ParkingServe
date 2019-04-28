package com.github.util;

import com.alibaba.fastjson.JSON;
import com.github.domain.AMap;
import com.github.domain.Label;
import com.github.domain.Marker;
import com.github.domain.PoisBean;
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
    private static final String URL_SUFFIX = "/v3/place/around";
    private static final String KEY = "a8688bbe69137c037bfa8b351cb0ef11";
    private static final String KEY_WORDS = "停车场";
    private static final String TYPES = "停车场相关";
    private static final String CITY = "天津";
    private static final String CITY_LIMIT = "true";
//    private static final String LOCATION = "117.200983,39.084158";

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }


    public static List<Marker> pOIAround(String location) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX + URL_SUFFIX + "?keywords="
                + KEY_WORDS + "&key=" + KEY + "&types=" + TYPES + "&city=" + CITY + "&=citylimit" + CITY_LIMIT + "&location=" + location, String.class);
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
