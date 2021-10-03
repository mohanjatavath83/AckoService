package com.acko.ackoservice.services.product;

import com.acko.ackoservice.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel addProduct(ProductModel productModel);

    List<ProductModel> getProducts();

}
