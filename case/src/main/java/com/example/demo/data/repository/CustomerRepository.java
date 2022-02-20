package com.example.demo.data.repository;

import com.example.demo.data.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
  //  Iterable<Customer> findCustomersByPhoneMatchesRegexAndCountry(String regex,int countryID);
    Page<Customer> findCustomersByCountry_Code(String code, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    @Query(value = "select * from customer c , country cs  where c.country = cs.id and c.phone ~ cs.regex = ?1",
            countQuery ="select count(*) from customer c , country cs  where c.country = cs.id and c.phone ~ cs.regex =?1" ,
            nativeQuery = true)
    Page<Customer> findCustomerByValidity(Boolean validity ,Pageable pageable);

    @Query(value = "select * from customer c , country cs  where c.country = cs.id and c.phone ~ cs.regex = ?2 and cs.code = ?1",
            countQuery = "select count(*) from customer c , country cs  where c.country = cs.id and c.phone ~ cs.regex = ?2 and cs.code = ?1",
            nativeQuery = true)
    Page<Customer> findCustomerByValidityAndCountry_Code(String code,Boolean validity,Pageable pageable);
}
