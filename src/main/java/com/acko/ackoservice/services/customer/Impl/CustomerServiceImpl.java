package com.acko.ackoservice.services.customer.Impl;

import com.acko.ackoservice.exception.ResourceAlreadyExists;
import com.acko.ackoservice.model.CustomerModel;
import com.acko.ackoservice.repository.CustomerRepository;
import com.acko.ackoservice.services.customer.CustomerService;
import com.acko.ackoservice.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneValidator phoneValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerNewCustomer(CustomerModel customer) {
        Optional<CustomerModel> existedCustomer = customerRepository.findById(customer.getMobileNumber());

        if (!phoneValidator.test(customer.getMobileNumber())) {
            throw new IllegalStateException(String.format("mobile Number invalid Exception ", customer.getMobileNumber()));
        }

        if (existedCustomer.isPresent()) {
            throw new ResourceAlreadyExists(String.format("user with mobile number alreday exist", customer.getUid()));
        }

        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setUid(customer.getMobileNumber());

        customerRepository.save(customer);
    }

    @Override
    public CustomerModel getCustomerByUid(String uid) {
        return customerRepository.getById(uid);
    }

    @Override
    public void removeCustomer(String uid) {
        customerRepository.deleteById(uid);
    }
}
