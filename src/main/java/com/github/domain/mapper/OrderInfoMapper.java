package com.github.domain.mapper;

import com.github.core.domain.UserInfo;
import com.github.domain.Marker;
import com.github.domain.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int doOrder(@Param("userInfo") UserInfo userInfo, @Param("marker") Marker marker);

    void orderPay(OrderInfo orderInfo);

    OrderInfo query_qrCode(OrderInfo orderInfo);

    List<OrderInfo> orderInfoList(@Param("userInfo") UserInfo userInfo, @Param("state") String state);

	void orderCancel(OrderInfo orderInfo);
}