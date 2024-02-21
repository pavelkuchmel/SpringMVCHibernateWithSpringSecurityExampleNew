package com.websystique.springmvc.model;

import org.springframework.stereotype.Component;

@Component
public class Company {

    private String name;
    private String address;

    public Company() {
        this.name = "Unknown";
        this.address = "Unknown";
    }

    public Company(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
