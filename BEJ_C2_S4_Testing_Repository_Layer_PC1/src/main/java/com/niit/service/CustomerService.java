package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExistsException;
import com.niit.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
    List<Customer> getAllCustomerData() throws CustomerNotFoundException;
    public String deleteCustomer(int cusId) throws CustomerNotFoundException;

    List<Customer> getCustomerByCustomerName(String customerName);
    List<Customer> getAllCustomerByProductName(String productName);
}
