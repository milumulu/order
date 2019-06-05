package com.milu.order.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

@Getter
public enum ProductStatusEnum implements IEnum<Integer> {
    UP(0, "正常"),
    DOWN(1, "下架")
    ;

    @EnumValue
    private Integer code;

    private  String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
