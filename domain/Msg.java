package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName tb_msg
 */
@TableName(value ="tb_msg")
@Data
public class Msg implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String msg;

    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}