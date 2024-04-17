package com.work.controller;

import com.google.common.collect.ImmutableMap;
import com.work.domain.Order;
import com.work.domain.request.OrderingRQ;
import com.work.domain.request.UpdateOrderStatusRQ;
import com.work.domain.response.OrderRS;
import com.work.service.OrderService;
import com.work.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author Jiayu Liu
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserAddressService userAddressService;

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model){
        model.setViewName("order/orderList");
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderRS> listProduct() {
        return orderService.listProduct();
    }


    @GetMapping(value = "/purchase")
    public String purchase(Model model, Integer id) {
        model.addAttribute("productId", id);
        return "order/orderPurchase";
    }

    @RequestMapping(value = "/ordering", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> ordering(@RequestBody OrderingRQ rq) {
        Integer orderId = orderService.ordering(rq);
        return ImmutableMap.of("id",orderId);
    }

    @GetMapping("/orderingSuccess")
    public ModelAndView orderingSuccess(Integer orderId, ModelAndView model) {
        model.setViewName("order/orderingSuccess");
        Order order = orderService.findById(orderId);
        model.addObject("order", order);
        return model;
    }

    @PostMapping("/updateOrderStatus")
    @ResponseBody
    public void updateOrderStatus(@RequestBody UpdateOrderStatusRQ rq){
        orderService.updateOrderStatus(rq.getId(),rq.getStatus());
    }

}
