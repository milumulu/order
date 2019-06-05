package com.milu.order.controller;

import com.milu.order.VO.ResultVO;
import com.milu.order.controller.Data.CreateOrderParams;
import com.milu.order.convert.OrderParams2OrderDTOConvert;
import com.milu.order.DTO.OrderDTO;
import com.milu.order.service.CreateService;
import com.milu.order.utils.ResultVOUtils;
import excepiton.OrderException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private CreateService createService;

    @PostMapping("/create")
    public ResultVO create(@Valid CreateOrderParams orderParams,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确 orderForm = {}", orderParams);
            throw new OrderException(1, bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderParams2OrderDTOConvert.convert(orderParams);

        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new OrderException(1, "购物车不能为空");
        }

        ResultVO resultVO = createService.createOrderDTO(orderDTO);
        if (resultVO.getCode().equals(0)) {
            Map<String, String> map = new HashMap<>();
            map.put("orderId", orderDTO.getOrderId());
            return ResultVOUtils.success(map);
        }

        return ResultVOUtils.error(1, "创建订单失败");
    }
}
