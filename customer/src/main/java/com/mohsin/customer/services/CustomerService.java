package com.mohsin.customer.services;

import com.mohsin.customer.responses.CustomerResponse;
import com.mohsin.customer.responses.FraudCheckResponse;
import com.mohsin.customer.models.Customer;
import com.mohsin.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor //All args notation creates constructor with args, so you dont have to manuall.
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    private final RestTemplate restTemplate;    //Injected through constructor

    public CustomerResponse registerCustomer(Customer request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        log.info("CustomerRegistrationRequest received with data: {}",customer);
        // todo: check if email valid
        // todo: check if email not taken
        // todo:  check if fraudster
        Customer customeRegistered = customerRepository.saveAndFlush(customer);
        CustomerResponse customerResponse = new CustomerResponse(customeRegistered);
        log.info("New customer registered.");

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://fraud-service/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        log.info("Response received from Fraud microservice: {}",fraudCheckResponse.getIsFraudulent());

        if(fraudCheckResponse.getIsFraudulent()){
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
        return customerResponse;
    }

    public Object getAllCustomers(){
        Pageable pageable = PageRequest.of(1, 10, Sort.Direction.ASC, "email");
        return customerRepository.findAll(pageable);
    }

    public Customer updateCustomerRecord(Customer upateCustomerRequest){
        Customer updatedCustomer = customerRepository.save(upateCustomerRequest);
        return updatedCustomer;
    }

    public Boolean deleteCustomerById(int customerId){
        customerRepository.deleteById(customerId);
        return true;
    }

}
