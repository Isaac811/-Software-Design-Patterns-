package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Cart
 * @TableName tb_cart
 */
@TableName(value ="tb_cart")
@Data
public class Cart implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer productId;

    private Integer userId;

    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}