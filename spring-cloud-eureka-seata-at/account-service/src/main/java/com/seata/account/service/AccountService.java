package com.seata.account.service;

/**
 * 账户服务
 *
 * @author 张朝阳
 * @date 2021-11-16 15:00:15
 */
public interface AccountService {
    /**
     * 扣减账户
     * @param userId
     * @param money
     * @return
     */
    Long deductAccount(Long userId, Long money);
}
