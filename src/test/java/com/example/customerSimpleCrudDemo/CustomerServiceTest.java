package com.example.customerSimpleCrudDemo;

import com.example.customerSimpleCrudDemo.jpa.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql(value="/sqlFile/customer-test.sql")
@Transactional
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerRepository customerRepository;
}
