package com.milu.order.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.milu.order.controller.Data.CreateOrderParams;
import com.milu.order.DTO.OrderDTO;
import com.milu.order.entity.OrderDetail;
import excepiton.OrderException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: order
 * @description: 转换
 * @author: 马建鹏
 * @create: 2019-06-04 10:38
 */
@Slf4j
public class OrderParams2OrderDTOConvert {

    public static OrderDTO convert(CreateOrderParams orderParams) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderParams.getName());
        orderDTO.setBuyerAddress(orderParams.getAddress());
        orderDTO.setBuyerPhone(orderParams.getPhone());
        orderDTO.setBuyerOpenid(orderParams.getOpenId());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderParams.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());

            orderDTO.setOrderDetailList(orderDetailList);
        } catch (Exception e) {
            log.error("【对象转换】错误，string = {}", orderParams.getItems());
            throw new OrderException(1, "参数不正确");
        }

        return orderDTO;
    }
}
