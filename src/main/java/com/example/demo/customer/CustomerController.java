package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
//@Deprecated to deprecate this api if a new version is created
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path = "all")
    public List<Customer> customer() {
        return customerService.getCustomers();
    }

    @PostMapping(path = "new")
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") String id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

    @PutMapping(path = "update")
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST FOR CUSTOMER WITH ID " + customer.getId());
        System.out.println(customer);
    }
}
