package com.joveo.testcontainer.dao;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.json.simple.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "users")
@TypeDefs({@TypeDef( name = "jsonb", typeClass = JsonBinaryType.class)})
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "bigint")
    private Integer userId;
    private String name;
    @Column(name = "email_id", columnDefinition = "text")
    private String emailId;
    @Type(type = "jsonb")
    @Column(name = "address", columnDefinition = "jsonb")
    private JSONObject address;
}
