package com.work.controller;

import com.work.domain.Evaluate;
import com.work.domain.Order;
import com.work.service.EvaluateService;
import com.work.service.OrderService;
import com.work.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author Jiayu Liu
 */
@Slf4j
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

    @Resource
    private EvaluateService evaluateService;

    @Resource
    private SysUserService userService;

    @Resource
    private OrderService orderService;

    @PostMapping("/insert")
    @ResponseBody
    public void insert(
            @RequestParam("orderId") Integer orderId,
            @RequestParam("content") String content) {
        Order order = orderService.findById(orderId);
        Evaluate evaluate = new Evaluate();
        evaluate.setProductId(order.getProductId());
        evaluate.setContent(content);
        evaluate.setCreateTime(LocalDateTime.now());
        evaluate.setUserId(userService.getUser().getId());
        evaluateService.saveOrUpdate(evaluate);
    }

    @PutMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        evaluateService.removeById(id);
    }
}
