package com.acko.ackoservice.controller;

import com.acko.ackoservice.dto.CustomerDto;
import com.acko.ackoservice.facade.customer.CustomerFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController extends BaseController {

    @Autowired
    private CustomerFacade customerFacade;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PostMapping
    public void registerCustomer(@RequestBody CustomerDto customerDto, HttpServletResponse response) {
        log.info("customer data = {}", customerDto);
        customerFacade.registerCustomer(customerDto);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @GetMapping
    @ResponseBody
    public CustomerDto getCustomerByUid(HttpServletResponse response) {
        String userID = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setStatus(HttpServletResponse.SC_OK);
        return customerFacade.getCustomerByUid(userID);

    }


}
