package com.seata.business.controller;

import com.seata.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 采购商品
     *
     * @return
     */
    @RequestMapping(value = "/purchase")
    public String purchase(Long userId, String commodityCode, int count) {
        try {
            Thread.sleep(2000);
            Long orderId = businessService.purchase(userId, commodityCode, count);
            return "创建订单成功，orderId:" + orderId;
        } catch (Exception e) {
            return "创建订单失败，失败原因：" + e.getMessage();
        }
    }
}
