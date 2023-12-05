package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customers")
@AllArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;

//    @Autowired
//    public CustomerControllerV2(CustomerService customerService) {
//        this.customerService = customerService;
//    }
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") String id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    public void getCustomerException(@PathVariable("customerId") String id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping(path = "new")
    public Customer createNewCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
        return customer;
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }

    @PutMapping(path = "update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST FOR CUSTOMER WITH ID " + customer.getId());
        System.out.println(customer);
        return customer;
    }
}
