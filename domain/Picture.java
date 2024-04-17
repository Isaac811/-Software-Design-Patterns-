package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName("tb_picture")
public class Picture {

    @TableId(type = IdType.AUTO)
    protected Integer id;


    protected LocalDateTime createTime;


    protected LocalDateTime updateTime;

    private String title;

    private String memo;

    private String url;

    private Integer userId;


}
