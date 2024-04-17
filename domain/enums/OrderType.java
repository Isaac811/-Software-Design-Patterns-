package com.work.domain.enums;

import lombok.Getter;

/**
 * @author Jiayu Liu
 */
@Getter
public enum OrderType {

    NORMAL(1, "Normal Order"),
    SALES_PROMOTION(2, "Promo Order"),
    ;

    private final Integer type;

    private final String desc;

    OrderType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
