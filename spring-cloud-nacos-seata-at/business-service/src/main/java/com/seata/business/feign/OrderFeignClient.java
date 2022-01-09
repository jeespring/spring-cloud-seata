package com.seata.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单服务Feign
 *
 * @author 张朝阳
 * @date 2021/11/19 23:57
 */
@FeignClient(name = "order-service", path = "/order")
public interface OrderFeignClient {
    /**
     * 创建订单
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @RequestMapping("/createOrder")
    Long createOrder(@RequestParam("userId") Long userId,
                      @RequestParam("commodityCode") String commodityCode,
                      @RequestParam("count") int count);

}
