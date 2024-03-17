package com.ys.customerApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ys.customerApi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
