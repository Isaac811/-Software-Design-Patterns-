package com.work.service.msg;

import org.springframework.stereotype.Service;

/**
 * Product Changed,notice.
 * @author Jiayu Liu
 */
@Service
public class ProductSubject extends Subject{

    public void     updatePrice(Integer productId){

        super.notifyObserver(productId);
    }
}
