package didispace.service;

/**
 * @author chentf(陈腾飞)
 * @描述：
 * @注意事项：
 * @e-mail chentengfei@choosefine.com
 * @date 2017/10/18
 */
public interface ComputeService {
    /**
     * 调用远程 a+b 会降级
     *
     * @param a
     * @param b
     * @return
     */
    String addService(Integer a, Integer b);
}
