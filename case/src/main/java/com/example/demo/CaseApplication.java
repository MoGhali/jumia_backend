package com.example.demo;

import com.example.demo.data.entity.Country;
import com.example.demo.data.entity.Customer;
import com.example.demo.data.repository.CountryRepository;
import com.example.demo.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseApplication.class, args);
	}
//@RestController
//@RequestMapping("/customers")
//	public class CustomerController{
//		@Autowired
//	private CustomerRepository customerRepository;
//		@GetMapping
//	public Iterable<Customer> getCustomers(){
//			return this.customerRepository.findAll();
//	}
//}
//	@RestController
//	@RequestMapping("/countries")
//	public class CountryController{
//		@Autowired
//		private CountryRepository countryRepository;
//		@GetMapping
//		public Iterable<Country> getCustomers(){
//			return this.countryRepository.findAll();
//		}
	//}





}
