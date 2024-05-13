package org.example.onlinrshop.service.impl;

import org.example.onlinrshop.model.entity.Customer;
import org.example.onlinrshop.repository.CustomerRepository;
import org.example.onlinrshop.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findByCustomerAddress(String name) {
        return customerRepository.findAllByAddress(name);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> createCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer findCustomer= customerRepository.findById(customer.getId()).orElse(null);
        findCustomer.setAddress(customer.getAddress());
        findCustomer.setCcNumber(customer.getCcNumber());
        findCustomer.setCityRegion(customer.getCityRegion());
        findCustomer.setEmail(customer.getEmail());
        findCustomer.setName(customer.getName());
        findCustomer.setPhone(customer.getPhone());

        return customerRepository.save(findCustomer);
    }

    @Override
    public String deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
        return id+"Hereglegchiin medeelelusdav...";
    }
}
