package com.example.demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Customer {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer customerId;

    @Column(name="NAME")
    private String customerName;

    @Column(name="PHONE")
    private String phone;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COUNTRY")
    private Country country;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
