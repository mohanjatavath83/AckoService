package com.acko.ackoservice.controller;

import com.acko.ackoservice.dto.ProductDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setup() {
        System.out.println("welcome");
    }


    @Test
    public void getProductsAPITest() {
        String baseURL = "http://localhost:" + port + "/products";
        ResponseEntity<ProductDto[]> response = testRestTemplate.getForEntity(baseURL, ProductDto[].class);
        //Assertions.assertEquals(response.getStatusCode().value(), HttpServletResponse.SC_OK);
        //Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().length).isGreaterThanOrEqualTo(2);
        Assertions.assertThat(response.getBody().length).isGreaterThanOrEqualTo(2);
    }

    @Test
    public void addNewProductTest() {
        ProductDto productDto = new ProductDto();
        productDto.setCode("SAMSUNG_55_INCHES_TV");
        productDto.setName("SAMSUNG_55_INCHES_TV QLED");
        productDto.setPrice(67000);
        String baseURL = "http://localhost:" + port + "/products";
        ResponseEntity<ProductDto> response = testRestTemplate.postForEntity(baseURL, productDto, ProductDto.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(response.getBody()).isNotNull();
        //Assertions.assertThat(response.getBody().getCode()).isEqualTo(productDto.getCode());
        org.junit.jupiter.api.Assertions.assertEquals(response.getBody().getCode(),productDto.getCode(),"product code should be same");
    }


}
