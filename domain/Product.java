package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("tb_product")
public class Product {

    @TableId(type = IdType.AUTO)
    protected Integer id;


    protected LocalDateTime createTime;


    protected LocalDateTime updateTime;

    private String title;

    private Integer point;

    private Integer pictureId;

    private String note;

    private String code;

    private String model;

    private Long stock;

    private Integer userId;

}
