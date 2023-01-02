package com.niit.repositoryTest;

import com.niit.domain.Customer;
import com.niit.domain.Product;
import com.niit.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Product product;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        product = new Product(12, "Fudge", "Chocolate");
        customer = new Customer(25, "Santiago", "5632322", product);
    }

    @AfterEach
    public void tearDown() {
        product = null;
        customer = null;
//        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Test case for saving customer object")
    void givenCustomerToSaveShouldReturnSavedCustomer() {
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
    }

    @Test
    @DisplayName("Test case for deleting customer object")
    public void givenCustomerToDeleteShouldDeleteCustomer() {
//        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustomerId()));

    }

    @Test
    @DisplayName("Test case for retrieving all the  customer object")
    public void givenCustomerReturnAllCustomerDetails() {

        //customerRepository.insert(customer);
        product = new Product(8, "iphone14", "op2");
        customer = new Customer(8, "paro", "965322", product);
        customerRepository.insert(customer);

        List<Customer> list = customerRepository.findAll();
        assertEquals(1, list.size());
        assertEquals("paro", list.get(0).getCustomerName());

    }

}
