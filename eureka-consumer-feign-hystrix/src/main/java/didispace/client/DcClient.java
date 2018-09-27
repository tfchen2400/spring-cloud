package didispace.client;

import didispace.client.hystrix.DcClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chentf(陈腾飞)
 * @描述：
 * @注意事项：
 * @e-mail chentengfei@choosefine.com
 * @date 2017/9/29
 */
@FeignClient(value = "${eureka-client}", fallback = DcClientHystrix.class)
public interface DcClient {

    @RequestMapping(value = "/add", method = RequestMethod.GET, params = {"a", "b"})
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
