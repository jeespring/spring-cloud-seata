package com.seata.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Storage
 *
 * @author 张朝阳
 * @date 2021-11-16 15:02:08
 */
@Data
@TableName("t_storage")
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String commodityCode;

    private String commodityName;

    private Integer count;

    private Long price;
}
