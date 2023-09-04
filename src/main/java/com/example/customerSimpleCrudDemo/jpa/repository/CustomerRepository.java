package com.example.customerSimpleCrudDemo.jpa.repository;

import com.example.customerSimpleCrudDemo.jpa.been.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}