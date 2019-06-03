package com.milu.order.controller;

import com.milu.order.VO.ResultVO;
import com.milu.order.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CreateService createService;

    @PostMapping("/create")
    public ResultVO create(@RequestBody ) {

    }
}
