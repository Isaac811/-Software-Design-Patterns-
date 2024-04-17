package com.work.domain.request;

import lombok.Data;

/**
 * @author Jiayu Liu
 */
@Data
public class UpdateOrderStatusRQ {
    private Integer id;

    private Integer status;
}
