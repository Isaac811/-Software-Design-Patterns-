package com.work.service;

import com.work.domain.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.work.domain.response.CartRS;
import com.work.domain.response.PayProductRQ;

import java.util.List;

/**
 * @author Jiayu Liu
 */
public interface CartService extends IService<Cart> {

    void addToCart(Integer id);

    List<CartRS> listProduct();

    List<PayProductRQ> getProduct(Integer cartId);
}
