package dev.pepper.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Customer extends PanacheEntity {

    public String name;
    public String email;
    public String phone;
    public String address;
    public String zipCode;
    public String cpf;
}
