package com.acko.ackoservice.services.product.impl;

import com.acko.ackoservice.model.ProductModel;
import com.acko.ackoservice.repository.ProductRepository;
import com.acko.ackoservice.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductModel addProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

}
