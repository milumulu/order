package com.milu.order.service;

import com.milu.order.VO.ResultVO;
import com.milu.order.dto.OrderDTO;
import com.milu.order.entity.OrderDetail;
import com.milu.order.entity.OrderMaster;
import com.milu.order.mapper.OrderDetailMapper;
import com.milu.order.mapper.OrderMasterMapper;
import com.milu.order.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@Service
@Transactional
public class CreateService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public ResultVO createOrderDTO(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            //TODO 查询商品价格
            //2. 计算订单总价
            //订单详情入库
        }
        //3. 写入订单数据库（orderMaster）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        int orderMasterInset = orderMasterMapper.insert(orderMaster);
        if (orderMasterInset != 1) {

        }
        //4. 扣库存

        return ResultVOUtils.success();
    }


}
