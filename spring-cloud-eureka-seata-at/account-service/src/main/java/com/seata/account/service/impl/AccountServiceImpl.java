package com.seata.account.service.impl;

import com.seata.account.mapper.AccountMapper;
import com.seata.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户服务Service
 *
 * @author 张朝阳
 * @date 2021-11-16 15:00:15
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Long deductAccount(Long userId, Long money) {
        log.info("[账户服务]>------>扣减账户开始");
        if (10000L == userId) {
            throw new RuntimeException("[账户服务]>------>扣减账户异常");
        }
        accountMapper.deductAccount(userId, money);
        log.info("[账户服务]>------>扣减账户结束");
        return money;
    }
}
