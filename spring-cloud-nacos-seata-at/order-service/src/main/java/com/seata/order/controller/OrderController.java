package com.seata.order.controller;


import com.seata.order.entity.Order;
import com.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务Controller
 *
 * @author 张朝阳
 * @date 2021-11-16 14:57:45
 */
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param userId
     * @param commodityCode
     * @param count
     * @return
     */
    @RequestMapping("createOrder")
    public Long createOrder(@RequestParam("userId") Long userId,
                                      @RequestParam("commodityCode") String commodityCode,
                                      @RequestParam("count") int count) {
        return orderService.createOrder(userId, commodityCode, count);
    }
}
