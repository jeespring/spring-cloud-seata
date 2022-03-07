package com.seata.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.storage.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 库存服务Mapper
 *
 * @author 张朝阳
 * @date 2021-11-16 15:02:08
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

    void deductStorage(@Param("commodityCode") String commodityCode,
                       @Param("count") int count);
}
