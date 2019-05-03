package com.github.web;

import com.alibaba.fastjson.JSON;
import com.github.core.domain.UserInfo;
import com.github.core.pojo.Result;
import com.github.core.service.UserInfoService;
import com.github.domain.Marker;
import com.github.domain.OrderInfo;
import com.github.domain.UniAppMapBean;
import com.github.service.OrderService;
import com.github.util.AMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wulitech
 */
@RestController
@RequestMapping("parking")
public class ParkingController {

    private UserInfoService userInfoService;

    private final OrderService orderService;

    @Autowired
    public ParkingController(UserInfoService userInfoService, OrderService orderService) {
        this.userInfoService = userInfoService;
        this.orderService = orderService;
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

    @RequestMapping("doOrder")
    public Result doOrder(@RequestBody String body) {
        Map map = JSON.parseObject(body, Map.class);
        Marker parkInfo = JSON.parseObject(JSON.toJSONString(map.get("parkInfo")), Marker.class);
        UserInfo userInfo = JSON.parseObject(JSON.toJSONString(map.get("userInfo")), UserInfo.class);
        String[] A = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int i = (int) (Math.random() * 26);
        int j = (int) (Math.random() * 20);
        parkInfo.setParkingPlace(A[i] + "区" + B[j] + "号");
        return orderService.doOrder(userInfo, parkInfo);
    }

    @RequestMapping(value = "order/order_list", method = RequestMethod.POST)
    public List<OrderInfo> orderInfoList(@RequestBody UserInfo userInfo, @RequestParam("state") String state) {
        return orderService.orderInfoList(userInfo, state);
    }

    @RequestMapping("order/pay")
    public Result orderPay(@RequestBody OrderInfo orderInfo) {
        return orderService.orderPay(orderInfo);
    }

    @RequestMapping("order/queryOrder")
    public @ResponseBody
    OrderInfo queryOrder(@RequestBody OrderInfo orderInfo) {
        return orderService.query_qrCode(orderInfo);
    }
}
