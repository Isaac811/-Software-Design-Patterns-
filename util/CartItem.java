package com.work.util;


import com.work.domain.Product;

public class CartItem {
    private Product product;
    private Integer total;

    public CartItem(Product product, Integer total) {
        this.product = product;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
