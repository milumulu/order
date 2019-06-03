package com.milu.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.milu.order.enums.OrderStatusEnum;
import com.milu.order.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMaster {

    @TableId(type = IdType.UUID)
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
    private OrderStatusEnum orderStatus = OrderStatusEnum.NEW;

    /** 支付状态，默认0为未支付 */
    private PayStatusEnum payStatus = PayStatusEnum.WAIT;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    @TableField(update = "now()")
    private Date updateTime;
}
