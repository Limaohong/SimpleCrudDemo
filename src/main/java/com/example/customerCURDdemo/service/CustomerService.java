package com.example.customerCURDdemo.service;

import com.example.customerCURDdemo.jpa.been.Customer;

public interface CustomerService {
    Customer getCustomerById(Long customerId);
}
