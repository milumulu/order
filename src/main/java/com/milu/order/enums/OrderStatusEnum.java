package com.milu.order.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum OrderStatusEnum implements IEnum<Integer> {
    NEW(0, "新订单"),
    FINISHED(1, "已完成"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
