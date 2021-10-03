package com.acko.ackoservice.facade.customer.impl;

import com.acko.ackoservice.dto.CustomerDto;
import com.acko.ackoservice.facade.customer.CustomerFacade;
import com.acko.ackoservice.model.CustomerModel;
import com.acko.ackoservice.services.customer.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    private CustomerService customerService;


    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void registerCustomer(CustomerDto customer) {

        CustomerModel customerModel = modelMapper.map(customer, CustomerModel.class);
        customerService.registerNewCustomer(customerModel);
    }

    @Override
    public CustomerDto getCustomerByUid(String uid) {
        CustomerModel customerModel = customerService.getCustomerByUid(uid);
        return modelMapper.map(customerModel, CustomerDto.class);
    }
}
