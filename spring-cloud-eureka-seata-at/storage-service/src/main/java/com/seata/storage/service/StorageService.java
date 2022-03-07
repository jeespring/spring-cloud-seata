package com.seata.storage.service;

/**
 * 库存服务
 *
 * @author 张朝阳
 * @date 2021-11-16 15:02:08
 */
public interface StorageService {

    /**
     * 查询商品价格
     *
     * @param commodityCode 商品编码
     * @return
     * @author 张朝阳
     * @date 2021/11/20 0:00
     */
    Long selectPrice(String commodityCode);

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编码
     * @param count         商品数量
     * @return
     * @author 张朝阳
     * @date 2021/11/20 0:00
     */
    int deductStorage(String commodityCode, int count);
}
