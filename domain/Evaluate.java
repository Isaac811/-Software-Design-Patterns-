package com.work.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @TableName tb_evaluate
 */
@TableName(value ="tb_evaluate")
@Data
public class Evaluate implements Serializable {
    private Integer id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer productId;

    private Integer userId;

    private String content;

    private static final long serialVersionUID = 1L;
}