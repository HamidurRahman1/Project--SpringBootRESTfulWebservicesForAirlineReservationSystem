package com.hamidur.RESTfulSpringBootMicroservice.services;

import com.hamidur.RESTfulSpringBootMicroservice.models.Customer;
import com.hamidur.RESTfulSpringBootMicroservice.repos.CustomerRepository;
import com.hamidur.RESTfulSpringBootMicroservice.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Set<Customer> getCustomers()
    {
        Set<Customer> customers = new LinkedHashSet<>();
        Iterable<Customer> customerIterable = customerRepository.findAll();
        if(customerIterable != null)
        {
            customerIterable.forEach(customer -> customers.add(customer));
            return customers;
        }
        return null;
    }

    public Customer getCustomerById(Integer customerId)
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
    }

    public Customer getCustomerByEmail(String email)
    {
        if(Util.validateEmail(email)) return customerRepository.findByEmailIgnoreCase(email);
        return null;
    }
}
