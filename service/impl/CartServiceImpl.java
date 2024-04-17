package com.work.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.work.domain.Cart;
import com.work.domain.Picture;
import com.work.domain.Product;
import com.work.domain.SysUser;
import com.work.domain.response.CartRS;
import com.work.domain.response.PayProductRQ;
import com.work.mapper.CartMapper;
import com.work.service.CartService;
import com.work.service.PictureService;
import com.work.service.ProductService;
import com.work.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {

    @Resource
    private ProductService productService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SysUserService userService;

    @Override
    public void addToCart(Integer id) {
        SysUser user = userService.getUser();
        Product product = productService.getById(id);
        Cart cart = getOne(Wrappers.<Cart>lambdaQuery().eq(Cart::getProductId, id).eq(Cart::getUserId, user.getId()));
        if (Objects.nonNull(cart)) {
            cart.setNum(cart.getNum() + 1);
            updateById(cart);
        } else {
            cart = new Cart();
            cart.setProductId(product.getId());
            cart.setUserId(user.getId());
            cart.setNum(1);
            cart.setCreateTime(LocalDateTime.now());
            save(cart);
        }

    }

    @Override
    public List<CartRS> listProduct() {
        SysUser user = userService.getUser();
        List<Cart> list = list(Wrappers.<Cart>lambdaQuery().eq(Cart::getUserId, user.getId()).orderByDesc(Cart::getUpdateTime).orderByDesc(Cart::getCreateTime));
        return Optional.ofNullable(list).orElseGet(Lists::newArrayList)
                .stream().map(cart -> {
                    Product product = productService.getById(cart.getProductId());
                    Picture picture = pictureService.getById(product.getPictureId());
                    CartRS cartRS = new CartRS();
                    cartRS.setId(cart.getId());
                    cartRS.setTitle(product.getTitle());
                    cartRS.setPoint(product.getPoint());
                    cartRS.setPictureImg(picture.getUrl());
                    cartRS.setNum(cart.getNum());
                    return cartRS;
                }).collect(Collectors.toList());
    }

    @Override
    public List<PayProductRQ> getProduct(Integer cartId) {
        Cart cart = getById(cartId);
        Product product = productService.getById(cart.getProductId());
        Picture picture = pictureService.getById(product.getPictureId());
        PayProductRQ payProductRQ = new PayProductRQ();
        payProductRQ.setCartId(cart.getId());
        payProductRQ.setTitle(product.getTitle());
        payProductRQ.setPictureImg(picture.getUrl());
        payProductRQ.setPoint(product.getPoint());
        payProductRQ.setNum(cart.getNum());
        payProductRQ.setTotal(product.getPoint() * cart.getNum());
        return Collections.singletonList(payProductRQ);
    }
}




