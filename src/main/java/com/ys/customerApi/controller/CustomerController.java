package com.ys.customerApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ys.customerApi.model.Customer;
import com.ys.customerApi.service.CustomerServices;
import com.ys.customerApi.service.CustomerServices.NewCustomerRequest;
import com.ys.customerApi.service.CustomerServices.UpdateCustomerRequest;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {
    private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }
    
    @GetMapping()
    public List<Customer> getCustomers() {
        return this.customerServices.getCustomers();
    }

    @PostMapping()
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        this.customerServices.addCustomer(request);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        this.customerServices.deleteCustomer(id);
    }

    @PutMapping()
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody UpdateCustomerRequest request) {
        this.customerServices.updateCustomer(id, request);
    }
}
