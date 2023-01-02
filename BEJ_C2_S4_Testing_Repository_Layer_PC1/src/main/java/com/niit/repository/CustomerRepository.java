package com.niit.repository;

import com.niit.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

//    @Query
@Query("{'product.productName':{$in:[?0]}}")
public List<Customer> findCustomerByProductName(String productName);

public List<Customer> findCustomerByCustomerName(String productName);


}
