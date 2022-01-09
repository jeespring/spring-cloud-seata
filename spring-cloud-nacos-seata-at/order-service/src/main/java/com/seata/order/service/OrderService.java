package com.seata.order.service;

/**
 * 订单服务
 *
 * @author 张朝阳
 * @date 2021-11-16 14:57:45
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId        用户Id
     * @param commodityCode 商品编码
     * @param count         数量
     * @return
     */
    Long createOrder(Long userId, String commodityCode, int count);
}
