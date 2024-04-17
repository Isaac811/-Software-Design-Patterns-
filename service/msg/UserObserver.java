package com.work.service.msg;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.work.domain.Cart;
import com.work.domain.Msg;
import com.work.domain.Product;
import com.work.service.CartService;
import com.work.service.MsgService;
import com.work.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Observer: Details notice
 * @author Jiayu Liu
 */
@Service
@Slf4j
@Lazy
public class UserObserver implements Observer {
    @Resource
    private MsgService msgService;

    @Resource
    private CartService cartService;

    @Resource
    private ProductService productService;

    @Override
    public void update(Integer productId) {
        // Product price changes: Notify all users who have added purchases.
        Product product = productService.getById(productId);
        List<Cart> carts = cartService.list(Wrappers.<Cart>lambdaQuery().eq(Cart::getProductId, productId));
        List<Msg> msgs = Optional.ofNullable(carts).orElseGet(Lists::newArrayList)
                .stream().map(cart -> {
                    Msg msg = new Msg();
                    msg.setCreateTime(LocalDateTime.now());
                    msg.setMsg(product.getTitle() + " price change。");
                    msg.setUserId(cart.getUserId());
                    return msg;
                }).collect(Collectors.toList());

        msgService.saveBatch(msgs);
    }
}
