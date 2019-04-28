package com.github.controller;

import com.github.domain.Marker;
import com.github.domain.UniAppMapBean;
import com.github.util.AMapUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wulitech
 */
@RestController
@RequestMapping("soraka")
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("getParkingInfo")
    public List<Marker> getParkingInfo(@RequestBody UniAppMapBean uniAppMapBean) {
        return AMapUtils.pOIAround(uniAppMapBean.getLongitude() + "," + uniAppMapBean.getLatitude());
    }
}
