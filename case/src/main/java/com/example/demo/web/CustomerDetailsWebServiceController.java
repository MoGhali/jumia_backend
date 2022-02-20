package com.example.demo.web;

import com.example.demo.business.domain.CustomerDetails;
import com.example.demo.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerDetailsWebServiceController {
    private CustomerService customerService;

    @Autowired
    public CustomerDetailsWebServiceController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin("*")
    @GetMapping
    public Page<CustomerDetails> getCustomers(@RequestParam(name = "code",defaultValue ="", required = false)String code,@RequestParam(name = "validity", required = false)Boolean validity, Pageable p){
        Page<CustomerDetails> customerDetailsList;

        if(!code.isBlank()&&validity!=null) {
            customerDetailsList = this.customerService.getCustomersDetailsPageByValidityAndCountry(code, validity, p);
        }else if(!code.isBlank()&&validity==null){
            customerDetailsList = this.customerService.getCustomersDetailsPageByCountry(code, p);
        }else if(code.isBlank()&&validity!=null){
            customerDetailsList = this.customerService.getCustomersDetailsPageByValidity(validity, p);
        }else {
            customerDetailsList = this.customerService.getCustomersDetailsPage(p);
        }
        return customerDetailsList;
        // return "customers";
    }
}
