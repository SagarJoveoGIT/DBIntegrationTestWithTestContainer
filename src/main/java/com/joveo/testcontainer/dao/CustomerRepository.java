package com.joveo.testcontainer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(nativeQuery = true, value = "select * from customers where name =" +
            " :name")
    public ArrayList<Customer> findByCustomerName(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from customers where " +
            "email_id = :email_id")
    public ArrayList<Customer> findByCustomerEmailId(@Param("email_id") String emailId);
}
