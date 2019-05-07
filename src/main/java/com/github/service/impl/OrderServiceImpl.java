package com.github.service.impl;

import com.github.core.domain.UserInfo;
import com.github.core.pojo.Result;
import com.github.core.pojo.ResultCode;
import com.github.domain.Marker;
import com.github.domain.OrderInfo;
import com.github.domain.mapper.OrderInfoMapper;
import com.github.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderInfoMapper orderInfoMapper;

    @Autowired
    public OrderServiceImpl(OrderInfoMapper orderInfoMapper) {
        this.orderInfoMapper = orderInfoMapper;
    }

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

    @Override
    public List<OrderInfo> orderInfoList(UserInfo userInfo, String state) {
        return orderInfoMapper.orderInfoList(userInfo, state);
    }

    @Override
    public Result doOrder(UserInfo userInfo, Marker marker) {
        int i = orderInfoMapper.doOrder(userInfo, marker);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.FORBIDDEN);
        }
    }

	@Override
	public Result orderCancel(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		 orderInfo.setState("9");
	     orderInfoMapper.orderCancel(orderInfo);
	     return Result.success();
	}
}
