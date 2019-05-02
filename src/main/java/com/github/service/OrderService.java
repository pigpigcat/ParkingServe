package com.github.service;

import com.github.core.domain.UserInfo;
import com.github.core.pojo.Result;
import com.github.domain.Marker;
import com.github.domain.OrderInfo;

import java.util.List;

public interface OrderService {

    Result doOrder(UserInfo userInfo, Marker marker);

    /**
     * 后台模拟支付
     *
     * @param orderInfo
     * @return
     */
    Result orderPay(OrderInfo orderInfo);

    OrderInfo query_qrCode(OrderInfo orderInfo);

    List<OrderInfo> orderInfoList(UserInfo userInfo, String state);
}
