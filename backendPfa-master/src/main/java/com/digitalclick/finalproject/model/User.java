package com.digitalclick.finalproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@DynamicUpdate
@Entity
    @Table(name = "users")
    public class User implements Serializable {

        private static final long serialVersionUID = -7527729256390829350L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private Integer id;

        @Column(name = "password")
        private String password;



        @ManyToOne( cascade = {CascadeType.MERGE})
        @JoinColumn(name = "role_ID")
        private Role role;



        @NotNull
        @Column(name = "firstName")
        private String firstName;
        @NotNull
        @Column(name = "lastName")
        private String lastName;

        @Column(name = "email")
        private String email;
         @Column(name = "adress")
         private String adress;


        @Column(name = "phone_number")
        private String phone_number;

    public User() {
    }

    public User(Integer UserId) {
        this.id=UserId;}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
