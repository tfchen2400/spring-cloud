package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chentf(陈腾飞)
 * @描述：
 * @注意事项：
 * @e-mail chentengfei@choosefine.com
 * @date 2017/9/27
 */
@RestController
public class consumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Value("${eureka-client}")
    private String eurekaClient;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(eurekaClient);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add?a=1&b=2";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
