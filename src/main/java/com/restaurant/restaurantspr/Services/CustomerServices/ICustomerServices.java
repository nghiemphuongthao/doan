package com.restaurant.restaurantspr.Services.CustomerServices;

import com.restaurant.restaurantspr.Entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServices {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer updatedCustomer);
    void deleteCustomer(Long id);
}
