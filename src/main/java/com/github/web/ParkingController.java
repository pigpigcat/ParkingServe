package com.github.web;

import com.github.domain.Marker;
import com.github.domain.UniAppMapBean;
import com.github.util.AMapUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wulitech
 */
@RestController
@RequestMapping("parking")
public class ParkingController {

    @RequestMapping("ping")
    public String test() {
        return "pong";
    }

    @PostMapping("getParkingInfo")
    public List<Marker> getParkingInfo(@RequestBody UniAppMapBean uniAppMapBean) {
        return AMapUtils.poiAround(uniAppMapBean.getLongitude() + "," + uniAppMapBean.getLatitude());
    }
}
