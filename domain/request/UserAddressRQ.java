package com.work.domain.request;

import lombok.Data;

/**
 * @author Jiayu Liu
 */
@Data
public class UserAddressRQ {
    private Integer id;
    private String address;

    private String phone;

    private String consignee;

}
