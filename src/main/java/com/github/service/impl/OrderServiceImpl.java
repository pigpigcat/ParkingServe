package com.github.service.impl;

import com.github.core.domain.UserInfo;
import com.github.core.mapper.UserInfoMapper;
import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import com.github.domain.OrderInfo;
import com.github.domain.mapper.OrderInfoMapper;
import com.github.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Override
	public Result orderPay(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		orderInfo.setState("2");
		orderInfo.setGmtPay(sdf.format(d));
		orderInfoMapper.orderPay(orderInfo);
	    return Result.success();
	    }
	@Override
	public OrderInfo query_qrCode(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoMapper.query_qrCode(orderInfo);
	}
	

}
