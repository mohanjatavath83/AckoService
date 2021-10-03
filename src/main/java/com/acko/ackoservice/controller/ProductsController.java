package com.acko.ackoservice.controller;

import com.acko.ackoservice.dto.ProductDto;
import com.acko.ackoservice.facade.product.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductFacade productFacade;

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        return productFacade.addProduct(productDto);
    }

    @GetMapping
    @ResponseBody
    public List<ProductDto> getProducts(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        return productFacade.getProducts();
    }


}
