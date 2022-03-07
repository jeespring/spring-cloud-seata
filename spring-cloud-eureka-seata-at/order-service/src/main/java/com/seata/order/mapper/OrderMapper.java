package com.seata.order.mapper;

import com.seata.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单服务Mapper
 *
 * @author 张朝阳
 * @date 2021-11-16 14:57:45
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
