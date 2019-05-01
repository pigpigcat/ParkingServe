package com.github.service;

import com.github.core.pojo.Result;
import com.github.domain.OrderInfo;

public interface OrderService {
	
	 /**
     * 后台模拟支付
     *
     * @param orderInfo
     * @return
     */
	Result orderPay(OrderInfo orderInfo);
	
	OrderInfo query_qrCode(OrderInfo orderInfo);
}
