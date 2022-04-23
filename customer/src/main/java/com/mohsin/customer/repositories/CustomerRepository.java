package com.mohsin.customer.repositories;

import com.mohsin.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>,JpaRepository<Customer, Integer> {
}
