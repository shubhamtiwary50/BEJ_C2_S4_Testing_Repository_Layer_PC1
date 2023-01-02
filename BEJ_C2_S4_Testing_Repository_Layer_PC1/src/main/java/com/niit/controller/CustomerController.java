package com.niit.controller;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExistsException;
import com.niit.exception.CustomerNotFoundException;
import com.niit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
//        ("/customerData/v1")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> saveCustomerData(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
       try {
           Customer customer11 = customerService.addCustomer(customer);
           return new ResponseEntity<>(customer11, HttpStatus.CREATED);
       } catch(CustomerAlreadyExistsException e){
           throw e;
       }
//        return new ResponseEntity<>(customerService.addCustomer(customer) , HttpStatus.CREATED);

    }
     //http://localhost:65100/api/v1/getdata
    @GetMapping("/getCustomers")
    public ResponseEntity<?> fetchAllCustomer() throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getAllCustomerData(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteCustomer/{custId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException, Exception {
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("/getCustomerByProductName/{productName}")
    public ResponseEntity<?> getCustomerByProductname(@PathVariable String productName) throws ClassNotFoundException,Exception{
        return new ResponseEntity<>(customerService.getAllCustomerByProductName(productName),HttpStatus.FOUND);
    }

    @GetMapping("/getCustomerByCustomername/{customerName}")
    public ResponseEntity<?> getDataByCustomerName(@PathVariable String customerName) throws ClassNotFoundException,Exception{
        return new ResponseEntity<>(customerService.getCustomerByCustomerName(customerName),HttpStatus.FOUND);
    }
}
