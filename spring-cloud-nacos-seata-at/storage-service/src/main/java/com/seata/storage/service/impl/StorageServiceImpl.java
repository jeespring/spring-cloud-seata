package com.seata.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seata.storage.entity.Storage;
import com.seata.storage.mapper.StorageMapper;
import com.seata.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 库存服务Service
 *
 * @author 张朝阳
 * @date 2021-11-16 15:02:08
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    /**
     * 查询商品价格
     *
     * @param commodityCode 商品编码
     * @return
     */
    @Override
    public Long selectPrice(String commodityCode) {
        QueryWrapper<Storage> wapper = new QueryWrapper<>();
        wapper.eq("commodity_code",commodityCode);
        return Optional.of(storageMapper.selectOne(wapper).getPrice()).orElse(null);
    }

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编码
     * @param count         数量
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deductStorage(String commodityCode, int count) {
        log.info("[库存服务]>------>扣减库存开始");
        storageMapper.deductStorage(commodityCode, count);
        log.info("[库存服务]>------>扣减库存结束");
        return count;
    }
}
