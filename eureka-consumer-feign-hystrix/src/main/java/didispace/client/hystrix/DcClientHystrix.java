package didispace.client.hystrix;

import didispace.client.DcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chentf(陈腾飞)
 * @描述：
 * @注意事项：
 * @e-mail chentengfei@choosefine.com
 * @date 2017/10/18
 */
@Component
public class DcClientHystrix implements DcClient {

    @Override
    public String add(Integer a, Integer b) {
        return "-9999";
    }
}
