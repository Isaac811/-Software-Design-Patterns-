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
@TableName("tb_admin")
public class Admin {

	@TableId(type = IdType.AUTO)
	protected Integer id;


	protected LocalDateTime createTime;


	protected LocalDateTime updateTime;

	private String username;//user name

	private String password;//password

}
