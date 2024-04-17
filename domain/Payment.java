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
@TableName("tb_payment")
public class Payment {

	@TableId(type = IdType.AUTO)
	protected Integer id;


	protected LocalDateTime createTime;


	protected LocalDateTime updateTime;

	private String name;

}