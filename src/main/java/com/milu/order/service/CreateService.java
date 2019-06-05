package com.milu.order.service;

import com.milu.order.DTO.CartDTO;
import com.milu.order.VO.ResultVO;
import com.milu.order.DTO.OrderDTO;
import com.milu.order.client.ProductClient;
import com.milu.order.entity.OrderDetail;
import com.milu.order.entity.OrderMaster;
import com.milu.order.entity.ProductInfo;
import com.milu.order.mapper.OrderDetailMapper;
import com.milu.order.mapper.OrderMasterMapper;
import com.milu.order.utils.KeyUtil;
import com.milu.order.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CreateService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public ResultVO createOrderDTO(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();

        //计算总价
        List<String> productInfoIds = orderDTO.getOrderDetailList().stream()
                .map(e -> e.getProductId())
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.getProductInfoListByIds(productInfoIds);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetailMapper.insert(orderDetail);
                }
            }
        }
        //2.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productClient.decreaseStock(cartDTOList);

        //3. 写入订单数据库（orderMaster）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterMapper.insert(orderMaster);

        return ResultVOUtils.success();
    }


}
