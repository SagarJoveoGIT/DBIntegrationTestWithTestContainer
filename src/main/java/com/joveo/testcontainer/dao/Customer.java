package com.joveo.testcontainer.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "bigint")
    private Integer customerId;
    private String name;
    @Column(name = "email_id", columnDefinition = "text")
    private String emailId;
}
