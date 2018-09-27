package didispace.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import didispace.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chentf(陈腾飞)
 * @描述：
 * @注意事项：
 * @e-mail chentengfei@choosefine.com
 * @date 2017/10/18
 */
@Service
public class ComputeServiceImpl implements ComputeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${eureka-client}")
    private String eurekaClient;

    @Override
    @HystrixCommand(fallbackMethod = "addServiceFallBack")
    public String addService(Integer a, Integer b) {
        return restTemplate.getForObject(eurekaClient + "add?a=" + a + "&b=" + b, String.class);
    }

    /**
     * 参数要和降级之前的一致
     *
     * @param a
     * @param b
     * @return
     */
    public String addServiceFallBack(Integer a, Integer b) {
        return "error";
    }
}
