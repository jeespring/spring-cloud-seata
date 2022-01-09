package com.seata.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 账户服务Mapper
 *
 * @author 张朝阳
 * @date 2021-11-16 15:00:15
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    int deductAccount(@Param("userId") Long userId, @Param("money")Long money);
}
