package com.milu.order.controller;

import com.milu.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: order
 * @description: 测试
 * @author: 马建鹏
 * @create: 2019-06-04 14:32
 */
@RestController
@RequestMapping("/order")
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //1.第一种方式（直接使用restTemplate,Url写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        //2.第二种方式（利用loadBalancerClient通过应该名获取Url，然后再使用restTemplate）
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        String msg = restTemplate.getForObject(url, String.class);

        //3.第三种方式（利用@LoadBalancer，可在restTemplate里直接使用应用名字）
        //String msg = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        //4.第四种方式（利用Feign的方式）
        String response = productClient.productMsg();
        return response;
    }
}
