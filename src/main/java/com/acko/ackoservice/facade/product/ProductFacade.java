package com.acko.ackoservice.facade.product;

import com.acko.ackoservice.dto.ProductDto;

import java.util.List;

public interface ProductFacade {

    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> getProducts();
}
