package didispace.controller;

import didispace.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private DcClient dcClient;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String consumer(@RequestParam Integer a, @RequestParam Integer b) {
        return dcClient.add(a, b);
    }
}
