package com.github.core.util;

import com.github.core.domain.AMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 高德地图API
 *
 * @author wulitech
 */
public class AMapUtils {

    private static final String URL_PERFIX = "https://restapi.amap.com";
    private static final String URL_SUFFIX = "/v3/place/around";
    private static final String KEY = "a8688bbe69137c037bfa8b351cb0ef11";
    private static final String KEY_WORDS = "停车场";
    private static final String TYPES = "停车场相关";
    private static final String CITY = "天津";
    private static final String CITY_LIMIT = "true";
    private static final String LOCATION = "117.200983,39.084158";

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }


    public static void POIAround() {
        Map<String, String> map = new HashMap<>(16);
        map.put("key", KEY);
        map.put("keywords", KEY_WORDS);
        map.put("types", TYPES);
        map.put("city", CITY);
        map.put("citylimit", CITY_LIMIT);
        map.put("location", LOCATION);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PERFIX + URL_SUFFIX, String.class, map);
        System.out.println(responseEntity);
    }

    public static void main(String[] args) {
        POIAround();
    }
}
