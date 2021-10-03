package com.acko.ackoservice.services.customer;

import com.acko.ackoservice.model.CustomerModel;

public interface CustomerService {

    void registerNewCustomer(CustomerModel customer);

    CustomerModel getCustomerByUid(String uid);
    void removeCustomer(String uid);
}
