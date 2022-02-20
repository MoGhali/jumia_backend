package com.example.demo.business.service;

import com.example.demo.business.domain.CountryDetails;
import com.example.demo.business.domain.CustomerDetails;
import com.example.demo.data.entity.Country;
import com.example.demo.data.entity.Customer;
import com.example.demo.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CountryService {
    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    public List<CountryDetails> getCountries(){
        Iterable<Country> countries = this.countryRepository.findAll();
        List<CountryDetails> countryDetailsList = new ArrayList<>();
        countries.forEach(country -> {
            CountryDetails countryDetails = countryToDetailsMapper(country);
            countryDetailsList.add(countryDetails);
        });
      return countryDetailsList;
    }


    private CountryDetails countryToDetailsMapper (Country country){
        CountryDetails countryDetails = new CountryDetails();
        countryDetails.setCode(country.getCode());
        countryDetails.setName(country.getCountryName());
        countryDetails.setId(country.getCountryId());
        countryDetails.setRegex(country.getRegex());
        return countryDetails;
    }
}
