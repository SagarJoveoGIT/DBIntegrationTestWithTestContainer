package com.joveo.testcontainer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(nativeQuery = true, value = "select * from users where name = " +
            ":name")
    public ArrayList<User> findByUserName(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from users where email_id =" +
            " :email_id")
    public ArrayList<User> findByUserEmailId(@Param("email_id") String emailId);
}
