package com.example.customerSimpleCrudDemo;

import com.example.customerSimpleCrudDemo.jpa.been.Customer;
import com.example.customerSimpleCrudDemo.jpa.repository.CustomerRepository;
import com.example.customerSimpleCrudDemo.service.CustomerService;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql(value="/sqlFile/customer-test.sql")
@Transactional
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Test
    public void testGetCustomerById(){
        Customer customer = customerService.getCustomerById(1L);
        assertEquals("Jason",customer.getName());
    }
    @Test
    public void testGetAllCustomers(){
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(3,customerList.size());
    }
    @Test
    public void testCreateOrUpdateCustomer(){
        Customer oldCustomer = customerService.getCustomerById(1L);
        oldCustomer.setPhone("123456789");
        customerService.createOrUpdateCustomer(oldCustomer);
        Customer newCustomer = customerService.getCustomerById(1L);
        assertEquals("123456789",newCustomer.getPhone());

        Customer createCustomer = new Customer();
        createCustomer.setName("Louis");
        createCustomer.setEmail("Louis@gmail.com");
        customerService.createOrUpdateCustomer(createCustomer);
        Customer tempCustomer = customerService.getCustomerById(4L);
        assertEquals("Louis",tempCustomer.getName());
    }
    @Test
    public void testBatchCreateOrUpdateCustomer(){
        List<Customer> tempCreateList = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setName("test1");
        customer1.setEmail("test1@gmail.com");
        Customer customer2 = new Customer();
        customer2.setName("test2");
        customer2.setEmail("test2@gmail.com");
        tempCreateList.add(customer1);
        tempCreateList.add(customer2);
        customerService.batchCreateOrUpdateCustomer(tempCreateList);
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(5,customerList.size());

        List<Customer> tempUpdateList = new ArrayList<>();
        Customer customer3 = new Customer();
        customer3.setId(1L);
        customer3.setEmail("test1@gmail.com");
        Customer customer4 = new Customer();
        customer4.setId(2L);
        customer4.setEmail("test2@gmail.com");
        tempUpdateList.add(customer3);
        tempUpdateList.add(customer4);
        customerService.batchCreateOrUpdateCustomer(tempUpdateList);
        Customer updateTest1 = customerService.getCustomerById(1L);
        Customer updateTest2 = customerService.getCustomerById(2L);
        assertEquals("test1@gmail.com",updateTest1.getEmail());
        assertEquals("test2@gmail.com",updateTest2.getEmail());
    }
    @Test
    public void testDeleteCustomerById(){
        customerService.deleteCustomerById(3L);
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(2,customerList.size());
    }
    @Test
    public void testBatchDeleteCustomer(){
        List<Customer> tempCustomerList = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(2L);
        Customer customer2 = new Customer();
        customer2.setId(3L);
        tempCustomerList.add(customer1);
        tempCustomerList.add(customer2);
        customerService.batchDeleteCustomer(tempCustomerList);
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(1,customerList.size());
    }
}
