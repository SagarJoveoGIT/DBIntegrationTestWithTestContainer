package com.joveo.testcontainer.dao.singletontestcontainer;

import com.joveo.testcontainer.dao.Customer;
import com.joveo.testcontainer.dao.CustomerRepository;
import com.joveo.testcontainer.dao.User;
import com.joveo.testcontainer.dao.UserRepository;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@ContextConfiguration(classes = {UserRepository.class})
@EnableAutoConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableJpaRepositories("com.joveo.testcontainer.dao")
@EntityScan("com.joveo.testcontainer.dao")
public class CustomerRepositoryTest extends PostgresTestContainer{
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeAll
    public void setup(){
        Customer customer = new Customer();
        customer.setName("customer-1");
        customer.setEmailId("customer-1@gmail.com");

        customerRepository.save(customer);
    }

    @Test
    public void testFindByName(){
        ArrayList<Customer> customers = customerRepository.findByCustomerName(
                "customer-1");
        Assertions.assertTrue(customers.size()!=0);
        Assertions.assertTrue(customers.get(0).getName().compareTo("customer-1")==0);
    }

    @Test
    public void testFindByEmailId(){
        ArrayList<Customer> customers = customerRepository.findByCustomerEmailId("customer-1@gmail.com");
        Assertions.assertTrue(customers.size()!=0);
        Assertions.assertTrue(customers.get(0).getEmailId().compareTo("customer-1" +
                "@gmail.com")==0);
    }
}
