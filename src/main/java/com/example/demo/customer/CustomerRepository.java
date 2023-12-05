package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

// I commented this '@Repository' because the Bean in the CustomerConfiguration file
// already provides the repo instance.
//@Primary
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
