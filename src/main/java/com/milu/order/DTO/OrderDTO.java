package com.milu.order.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.milu.order.entity.OrderDetail;
import com.milu.order.enums.OrderStatusEnum;
import com.milu.order.enums.PayStatusEnum;
import com.milu.order.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信OpenId */
    private String buyerOpenid;

    /** 订单总额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认0为新下单 */
    private Integer orderStatus;

    /** 支付状态，默认0为未支付 */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using  = Date2LongSerializer.class)
    private Date createTime;

    /** 修改时间 */
    @JsonSerialize(using  = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum;

    @JsonIgnore
    public PayStatusEnum getPayStatusEunm;
}
