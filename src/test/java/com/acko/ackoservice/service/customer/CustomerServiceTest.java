package com.acko.ackoservice.service.customer;

import com.acko.ackoservice.model.CustomerModel;
import com.acko.ackoservice.repository.CustomerRepository;
import com.acko.ackoservice.validator.PhoneValidator;
import org.mockito.Mock;

public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PhoneValidator phoneValidator;

    public void saveNewCustomerTest()
    {
        CustomerModel customer = new CustomerModel();
        customer.setMobileNumber("+919391488477");
    }
}
