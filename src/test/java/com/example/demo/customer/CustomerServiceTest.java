package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService();
        underTest.customerRepository = customerRepository;
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {

        Customer mikel = new Customer(
                "1",
                "Mikel Baines",
                "helloNurse",
                "mikel.baines@example.com"
        );

        Customer ali = new Customer(
                "2",
                "Ali Hassan",
                "helloNurse",
                "ali.hassan@example.com"
        );

        customerRepository.saveAll(Arrays.asList(mikel, ali));

        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {

        Customer customer = new Customer(
                "1",
                "Mikel Baines",
                "helloNurse",
                "mikel.baines@example.com"
        );

        customerRepository.save(customer);

        Customer actual = underTest.getCustomer("1");

        assertEquals("1", actual.getId());
        assertEquals("Mikel Baines", actual.getName());
        assertEquals("mikel.baines@example.com", actual.getEmail());
    }
}