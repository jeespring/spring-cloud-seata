package com.seata.business.service;

/**
 * 采购服务
 *
 * @author 张朝阳
 * @date 2021/11/20 0:53
 */
public interface BusinessService {

    /**
     * 采购商品
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    Long purchase(Long userId, String commodityCode, int count);
}
