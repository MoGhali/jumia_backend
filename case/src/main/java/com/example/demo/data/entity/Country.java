package com.example.demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Country {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer countryId;

    @Column(name = "NAME")
    private String countryName;

    @Column(name = "CODE")
    private String code;

    @Column(name = "REGEX")
    private String regex;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
