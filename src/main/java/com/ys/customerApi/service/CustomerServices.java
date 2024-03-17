package com.ys.customerApi.service;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.ys.customerApi.model.Customer;
import com.ys.customerApi.repository.CustomerRepository;

@RestController
public class CustomerServices {
    private final CustomerRepository customerRepository;

    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public record NewCustomerRequest(
            Integer id,
            String name,
            String email,
            Integer age) {
    };

    public void addCustomer(NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        this.customerRepository.deleteById(id);
    }

    public record UpdateCustomerRequest(
            Integer id,
            String name,
            String email,
            Integer age) {
    };

    public void updateCustomer(Integer id, UpdateCustomerRequest request) {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Customer not found with Id: " + id));
        updateCustomer.setName(request.name());
        updateCustomer.setEmail(request.email());
        updateCustomer.setAge(request.age());
        customerRepository.save(updateCustomer);
    }
}
