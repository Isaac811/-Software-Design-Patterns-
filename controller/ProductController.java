/**
 *
 */
package com.work.controller;


import com.work.domain.response.ProductRS;
import com.work.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Jiayu Liu
 */

@Slf4j
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model){
        model.setViewName("product/productList");
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

    @PutMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        productService.removeById(id);
    }

}
