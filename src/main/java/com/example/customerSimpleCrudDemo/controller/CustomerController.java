package com.example.customerSimpleCrudDemo.controller;

import com.example.customerSimpleCrudDemo.jpa.been.Customer;
import com.example.customerSimpleCrudDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("getCustomer")
    public Customer getCustomer(Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("createOrUpdateCustomer")
    public void createOrUpdateCustomer(@RequestBody Customer customer) {
        try {
            customerService.createOrUpdateCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("batchCreateOrUpdateCustomer")
    public void batchCreateOrUpdateCustomer(@RequestBody List<Customer> customerList) {
        try {
            customerService.batchCreateOrUpdateCustomer(customerList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("deleteCustomer")
    public void deleteCustomer(Long customerId){
        try {
            customerService.deleteCustomerById(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("batchDeleteCustomer")
    public void batchDeleteCustomer(@RequestBody List<Customer> customerList){
        try {
            customerService.batchDeleteCustomer(customerList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
