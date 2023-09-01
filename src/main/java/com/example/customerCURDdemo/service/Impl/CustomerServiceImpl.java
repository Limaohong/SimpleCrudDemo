package com.example.customerCURDdemo.service.Impl;

import com.example.customerCURDdemo.jpa.been.Customer;
import com.example.customerCURDdemo.jpa.repository.CustomerRepository;
import com.example.customerCURDdemo.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long customerId) {
        return null;
    }
}
