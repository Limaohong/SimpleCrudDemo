package com.example.customerSimpleCrudDemo.service.Impl;

import com.example.customerSimpleCrudDemo.jpa.been.Customer;
import com.example.customerSimpleCrudDemo.jpa.repository.CustomerRepository;
import com.example.customerSimpleCrudDemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchCreateOrUpdateCustomer(List<Customer> customerList) {
        customerRepository.saveAll(customerList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchDeleteCustomer(List<Customer> customerList) {
        customerRepository.deleteAll(customerList);
    }
}
