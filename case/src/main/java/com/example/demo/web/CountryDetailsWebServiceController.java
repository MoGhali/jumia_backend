package com.example.demo.web;

import com.example.demo.business.domain.CountryDetails;
import com.example.demo.business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryDetailsWebServiceController {
    private CountryService countryService;

    @Autowired
    public CountryDetailsWebServiceController(CountryService countryService) {
        this.countryService = countryService;
    }
    @CrossOrigin("*")
    @GetMapping
    public List<CountryDetails> getCountries(){
        List<CountryDetails> countryDetailsList = this.countryService.getCountries();
        return countryDetailsList;
    }
}
