package com.example.demo.business.service;

import com.example.demo.business.domain.CustomerDetails;
import com.example.demo.data.entity.Customer;
import com.example.demo.data.repository.CountryRepository;
import com.example.demo.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

private final CountryRepository countryRepository;
private final CustomerRepository customerRepository;

@Autowired
    public CustomerService(CountryRepository countryRepository, CustomerRepository customerRepository) {
        this.countryRepository = countryRepository;
        this.customerRepository = customerRepository;
    }

    public Page<CustomerDetails> getCustomersDetailsPageByCountry(String countryCode, Pageable p){
    Page<Customer> customers = this.customerRepository.findCustomersByCountry_Code(countryCode, p);

       Page<CustomerDetails>  customerDetailsPage = customers.map(this::customerToDetailsMapper);
        return customerDetailsPage;
    }

    public Page<CustomerDetails> getCustomersDetailsPage(Pageable p){
        Page<Customer> customers = this.customerRepository.findAll(p);

        Page<CustomerDetails>  customerDetailsPage = customers.map(this::customerToDetailsMapper);
        return customerDetailsPage;
    }

    public Page<CustomerDetails> getCustomersDetailsPageByValidity(Boolean validity , Pageable p){
        Page<Customer> customers = this.customerRepository.findCustomerByValidity(validity,p);

        Page<CustomerDetails>  customerDetailsPage = customers.map(this::customerToDetailsMapper);
        return customerDetailsPage;
    }

    public Page<CustomerDetails> getCustomersDetailsPageByValidityAndCountry(String countryCode,Boolean validity, Pageable p){
        Page<Customer> customers = this.customerRepository.findCustomerByValidityAndCountry_Code(countryCode,validity,p);

        Page<CustomerDetails>  customerDetailsPage = customers.map(this::customerToDetailsMapper);
        return customerDetailsPage;
    }


    private CustomerDetails customerToDetailsMapper (Customer customer){
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setName(customer.getCustomerName());
        customerDetails.setCountry(customer.getCountry().getCountryName());
        customerDetails.setPhone(customer.getPhone());
        customerDetails.setId(customer.getCustomerId());
        customerDetails.setCountryCode(customer.getCountry().getCode());
        boolean status = customer.getPhone().matches(customer.getCountry().getRegex());
        if(status)
            customerDetails.setStatus("Valid");
        else
            customerDetails.setStatus("InValid");
    return customerDetails;
    }
}
