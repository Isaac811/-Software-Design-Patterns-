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
@TableName("tb_announcement")
public class Announcement {

    @TableId(type = IdType.AUTO)
    protected Integer id;


    protected LocalDateTime createTime;


    protected LocalDateTime updateTime;

    private String content;

    private Integer userId;

}