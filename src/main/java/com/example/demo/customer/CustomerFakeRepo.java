package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

// I commented this because the Bean in the CustomerConfiguration file
// already provides the repo instance.
//@Repository(value = "fake")
public class CustomerFakeRepo implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer("1C","Jacob Cain", "Cain@J", "email@gmail.com"),
                new Customer("2C","James Miller", "Miller@J", "email@gmail.com"),
                new Customer("3C","Martha Care", "Care@M", "email@gmail.com")
        );
    }
}
