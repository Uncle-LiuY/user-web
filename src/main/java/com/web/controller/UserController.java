package com.web.controller;


import com.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/getname")
    public User get() throws Exception {
        //getForObject() 发送一个HTTP GET请求，返回的请求体将映射为一个对象
        //user-api 为调用的uri（服务提供者（Eureka 客户端）地址）在eureka上注册的application.name
        return restTemplate.getForObject( "http://user-api/user/getname",User.class);

    }

}
