package com.work.domain.request;

import lombok.Data;

/**
 * @author Jiayu Liu
 */
@Data
public class ProductRQ {
    protected Integer id;

    private String title;

    private Integer point;

    private Integer pictureId;//主图

    private String pictureImg;

    private String note;

    private Long stock;


    private Integer spId;
    private Integer type;

    private Integer total;

    private Integer subtraction;
}
