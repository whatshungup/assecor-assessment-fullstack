package com.example.assecor.persistence;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class PersonEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String zipcode;
    private String city;
    @ManyToOne
    @JoinColumn(name="COLOR_ID")
    private ColorEntity color;


    public PersonEntity(){

    }
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipCode) {
        this.zipcode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String ort) {
        this.city = ort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setColor(ColorEntity colorCode) {
        this.color = colorCode;
    }

    public ColorEntity getColor() {
        return color;
    }
}
