package com.work.controller;


import com.work.domain.JsonResult;
import com.work.domain.response.CartRS;
import com.work.domain.response.PayProductRQ;
import com.work.service.CartService;
import com.work.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jiayu Liu
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    ProductService productService;

    @Resource
    private CartService cartService;

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model) {
        model.setViewName("order/cart");
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<CartRS> listCart() {
        return cartService.listProduct();
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public JsonResult addToCart(Integer id) {
        cartService.addToCart(id);
        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }

    @PutMapping(value = "/delete/{id}")
    @ResponseBody
    public JsonResult deleteFromCart(@PathVariable("id") Integer id) {
        cartService.removeById(id);

        JsonResult result = new JsonResult();
        result.setToSuccess();
        return result;
    }

    @GetMapping(value = "/getProduct")
    @ResponseBody
    public List<PayProductRQ> getProduct(Integer cartId) {
        return cartService.getProduct(cartId);
    }
}
