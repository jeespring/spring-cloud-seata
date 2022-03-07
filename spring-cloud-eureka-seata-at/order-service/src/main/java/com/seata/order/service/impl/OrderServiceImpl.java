package com.seata.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.order.entity.Order;
import com.seata.order.feign.AccountFeignClient;
import com.seata.order.feign.StorageFeignClient;
import com.seata.order.mapper.OrderMapper;
import com.seata.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张朝阳
 * @date 2021-11-16 14:57:45
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountFeignClient accountService;

    @Autowired
    private StorageFeignClient storageService;

    /**
     * 创建订单
     *
     * @param userId
     * @param commodityCode
     * @param count
     * @return 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
    public Long createOrder(Long userId, String commodityCode, int count) {
        log.info("[订单服务]>------>创建订单开始");
        //扣减账户余额
        Long price = storageService.selectPrice(commodityCode);
        Long money = price * count;
        // 创建订单
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setMoney(money);
        order.setCount(count);
        orderMapper.insert(order);
        // 扣减账户
        log.info("[订单服务]>------>扣减账户开始");
        accountService.deductAccount(order.getUserId(), money);
        log.info("[订单服务]>------>扣减账户结束");

        log.info("[订单服务]>------>创建订单结束");
        return order.getId();
    }

}
