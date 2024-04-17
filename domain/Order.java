/**
 *
 */
package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("tb_order")
public class Order {

    @TableId(type = IdType.AUTO)
    protected Integer id;


    protected LocalDateTime createTime;

    protected LocalDateTime updateTime;

    private String orderNumber;

    private Integer userId;

    private String address;

    private String phone;

    private String consignee;

    private LocalDateTime payTime;

    private LocalDateTime shipTime;

    private LocalDateTime confirmTime;

    private Integer status;

    private Integer finalPrice;

    private Integer totalPrice;

    private Integer type;

    private String spDescription;

    private String productName;

    private Integer productId;
}
