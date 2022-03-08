package com.seata.business.service.impl;

import com.seata.business.feign.OrderFeignClient;
import com.seata.business.feign.StorageFeignClient;
import com.seata.business.service.BusinessService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 采购服务Service
 *
 * @author 张朝阳
 * @date 2021/11/19 23:57
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private StorageFeignClient storageService;

    @Autowired
    private OrderFeignClient orderService;

    /**
     * 扣减库存-》创建订单
     *
     * @param userId        用户Id
     * @param commodityCode 商品编码
     * @param count         数量
     */
    @Override
    @GlobalTransactional(timeoutMills = 10000, name = "spring-cloud-seata", rollbackFor = Exception.class)
    public Long purchase(Long userId, String commodityCode, int count) {
        log.info("开始全局事务，XID = " + RootContext.getXID());

        log.info("[采购服务]>------>扣减库存开始");
        storageService.deductStorage(commodityCode, count);
        log.info("[采购服务]>------>扣减库存结束");

        log.info("[采购服务]>------>创建订单开始");
        Long orderId = orderService.createOrder(userId, commodityCode, count);
        log.info("[采购服务]>------>创建订单结束");

        return orderId;
    }
}
