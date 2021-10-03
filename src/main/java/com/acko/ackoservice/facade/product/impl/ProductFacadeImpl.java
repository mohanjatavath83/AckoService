package com.acko.ackoservice.facade.product.impl;

import com.acko.ackoservice.dto.ProductDto;
import com.acko.ackoservice.facade.product.ProductFacade;
import com.acko.ackoservice.model.ProductModel;
import com.acko.ackoservice.services.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductFacadeImpl implements ProductFacade {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ProductService productService;

    public ProductDto addProduct(ProductDto productDto) {
        return modelMapper.map(productService.addProduct(modelMapper.map(productDto, ProductModel.class)), ProductDto.class);
    }

    public List<ProductDto> getProducts() {
        List<ProductModel> products = productService.getProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if (products != null && products.size() > 0) {
            for (ProductModel product : products) {
                productDtos.add(modelMapper.map(product, ProductDto.class));
            }
        }
        return productDtos;
    }
}
