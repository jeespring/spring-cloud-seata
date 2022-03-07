package com.seata.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 账户服务Feign
 *
 * @author 张朝阳
 * @date 2021/11/19 23:57
 */
@FeignClient(name = "account-service", path = "/account")
public interface AccountFeignClient {

    @RequestMapping("/deductAccount")
    Long deductAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money);

}
