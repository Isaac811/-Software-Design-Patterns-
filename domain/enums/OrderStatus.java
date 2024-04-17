package com.work.domain.enums;

import lombok.Getter;

/**
 * @author Jiayu Liu
 */
public enum OrderStatus {

    PAYED(1, "Payed"),
    SHIPPED(2, "Delivered"),
    ENDED(3, "Finished"),
    ;

    @Getter
    private final Integer status;
    @Getter
    private final String desc;

    OrderStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }


}
