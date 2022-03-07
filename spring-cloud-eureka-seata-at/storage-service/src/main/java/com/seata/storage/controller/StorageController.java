package com.seata.storage.controller;

import com.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存服务Controller
 *
 * @author 张朝阳
 * @date 2021-11-16 15:02:08
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 查询商品价格
     *
     * @param commodityCode 商品编码
     * @return
     */
    @RequestMapping("selectPrice")
    public Long selectPrice(@RequestParam("commodityCode") String commodityCode) {
        return storageService.selectPrice(commodityCode);
    }

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编码
     * @param count         商品数量
     * @return
     */
    @RequestMapping("deductStorage")
    public int deductStorage(@RequestParam("commodityCode") String commodityCode,
                             @RequestParam("count") int count) {
        return storageService.deductStorage(commodityCode, count);
    }
}
