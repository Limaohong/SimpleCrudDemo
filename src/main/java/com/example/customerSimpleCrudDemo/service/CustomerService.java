package com.example.customerSimpleCrudDemo.service;

import com.example.customerSimpleCrudDemo.jpa.been.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long customerId);
    List<Customer> getAllCustomers();

    void createOrUpdateCustomer(Customer customer);

    void batchCreateOrUpdateCustomer(List<Customer> customerList);

    void deleteCustomerById(Long customerId);

    void batchDeleteCustomer(List<Customer> customerList);

}
