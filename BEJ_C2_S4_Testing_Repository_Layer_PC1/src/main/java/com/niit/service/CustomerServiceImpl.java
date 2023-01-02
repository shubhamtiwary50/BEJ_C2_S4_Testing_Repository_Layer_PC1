package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExistsException;
import com.niit.exception.CustomerNotFoundException;
import com.niit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

   @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    @Override
//    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
//        return customerRepository.save(customer);
//    }

    @Override
    public List<Customer> getAllCustomerData() throws CustomerNotFoundException {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(int customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isEmpty()){
          throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(customerId);
        return "User deleted successfully";
    }

    @Override
    public List<Customer> getAllCustomerByProductName(String productName) {
        return customerRepository.findCustomerByProductName(productName);
    }

    @Override
    public List<Customer> getCustomerByCustomerName(String customerName) {
        return customerRepository.findCustomerByCustomerName(customerName);
    }
}
