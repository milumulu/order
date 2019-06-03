package com.milu.order.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum PayStatusEnum implements IEnum<Integer> {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    PAID(3, "已退款"),
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
