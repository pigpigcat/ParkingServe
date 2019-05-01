package com.github.web;

import com.github.core.domain.UserInfo;
import com.github.core.pojo.Result;
import com.github.core.service.UserInfoService;
import com.github.domain.Marker;
import com.github.domain.UniAppMapBean;
import com.github.util.AMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final UserInfoService userInfoService;

    @Autowired
    public ParkingController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping("ping")
    public String test() {
        return "pong";
    }

    @PostMapping("getParkingInfo")
    public List<Marker> getParkingInfo(@RequestBody UniAppMapBean uniAppMapBean) {
        return AMapUtils.poiAround(uniAppMapBean.getLongitude() + "," + uniAppMapBean.getLatitude());
    }

    @RequestMapping("user/reg")
    public Result userReg(@RequestBody UserInfo userInfo) {
        return userInfoService.signUp(userInfo);
    }

    @RequestMapping("user/login")
    public Result userLogin(@RequestBody UserInfo userInfo) {
        return userInfoService.signOn(userInfo);
    }
}
