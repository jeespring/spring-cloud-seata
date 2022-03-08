package com.seata.account.controller;


import com.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户服务Controller
 *
 * @author 张朝阳
 * @date 2021-11-16 15:00:15
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户金额
     *
     * @param userId
     * @param money
     * @return
     */
    @RequestMapping("/deductAccount")
    public Long deductAccount(Long userId, Long money) {
        return accountService.deductAccount(userId, money);
    }
}
