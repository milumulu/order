package com.milu.order.DTO;

import lombok.Data;

/**
 * @program: product
 * @description:
 * @author: 马建鹏
 * @create: 2019-06-05 14:24
 */
@Data
public class CartDTO {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
