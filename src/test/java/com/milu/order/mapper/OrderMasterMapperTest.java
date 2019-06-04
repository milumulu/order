package com.milu.order.mapper;

import com.milu.order.entity.OrderMaster;
import com.milu.order.enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterMapperTest {

    @Autowired
    private OrderMasterMapper mapper;

    @Test
    public void createTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("小白");
        orderMaster.setBuyerAddress("广州");
        orderMaster.setBuyerOpenid("oGrBx5o1RvMyiIKWmudbjYXliYOE");
        orderMaster.setBuyerPhone("17749742219");
        orderMaster.setOrderAmount(new BigDecimal(13));
        int count = mapper.insert(orderMaster);
        Assert.assertTrue(count != 0);
    }
}