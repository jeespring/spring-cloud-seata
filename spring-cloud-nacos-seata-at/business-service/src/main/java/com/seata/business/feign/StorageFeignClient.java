package com.seata.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务Feign
 *
 * @author 张朝阳
 * @date 2021/11/19 23:57
 */
@FeignClient(name = "storage-service", path = "/storage")
public interface StorageFeignClient {

    /**
     * 扣减库存
     * @param commodityCode
     * @param count
     */
    @RequestMapping("/deductStorage")
    int deductStorage(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);
}
