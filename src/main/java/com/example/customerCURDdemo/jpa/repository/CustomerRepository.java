package com.example.customerCURDdemo.jpa.repository;

import com.example.customerCURDdemo.jpa.been.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}