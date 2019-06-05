package com.milu.order.VO;

//Http请求的最外层对象

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private  String msg;

    /** 具体内容 */
    private T data;
}
