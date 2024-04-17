package com.work.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.work.domain.Cart;
import com.work.domain.response.ProductRS;
import com.work.service.CartService;
import com.work.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jiayu Liu
 */
@Slf4j
@Controller
@RequestMapping(value = "/manage/product")
public class ManageProductController {
    @Autowired
    ProductService productService;

    @Resource
    private CartService cartService;

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model) {
        model.setViewName("manage/manageProduct");
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductRS> listProduct() {
        return productService.listProduct();
    }


    @GetMapping(value = "/detail")
    public String detail(Integer id, Model model) {
        ProductRS productRS = productService.detail(id);
        model.addAttribute("product", productRS);
        return "product/productView";
    }

    @PostMapping("/insert")
    @ResponseBody
    public void insert(@RequestParam("title") String title,
                       @RequestParam("point") String point,
                       @RequestParam("stock") String stock,
                       @RequestParam("type") Integer type,
                       @RequestParam("total") Integer total,
                       @RequestParam("subtraction") Integer subtraction,
                       @RequestParam("pictureImg") MultipartFile image) {
        productService.insert(title, point, stock, type, total, subtraction, image);
    }

    @PutMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        productService.removeById(id);
        cartService.remove(Wrappers.<Cart>lambdaQuery().eq(Cart::getProductId, id));
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(@RequestParam("productId") Integer productId,
                       @RequestParam("point") String point) {
       productService.update(productId,point);
    }
}
