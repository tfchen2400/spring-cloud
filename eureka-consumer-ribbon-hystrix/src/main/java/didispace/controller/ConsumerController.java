package didispace.controller;

import didispace.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ConsumerController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String dc(Integer a, Integer b) {
        return computeService.addService(a, b);
    }
}
