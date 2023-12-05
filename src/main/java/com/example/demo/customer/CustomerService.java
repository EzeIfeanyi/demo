package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

//    @Autowired
////    public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) {
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(String id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    "customer with id " + id + " not found"
                            );
                            log.error("error in getting customer {}, {}", id, notFoundException.toString() );
                            return notFoundException;
                        }
                );
    }
}
