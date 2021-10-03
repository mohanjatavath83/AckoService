package com.acko.ackoservice.facade.customer;

import com.acko.ackoservice.dto.CustomerDto;

public interface CustomerFacade {

    void registerCustomer(CustomerDto customer);

    CustomerDto getCustomerByUid(String uid);
}
