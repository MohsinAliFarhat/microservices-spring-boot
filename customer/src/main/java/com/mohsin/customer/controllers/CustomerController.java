package com.mohsin.customer.controllers;

import com.mohsin.customer.models.Customer;
import com.mohsin.customer.responses.CustomerResponse;
import com.mohsin.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public CustomerResponse registerCustomer(@RequestBody Customer customerRequest){
        log.info("New customer Registration {}",customerRequest);
        return customerService.registerCustomer(customerRequest);
    }

    @GetMapping
    public Object registerCustomer(HttpServletRequest request){
        log.info("Get all customers request received {}", request.getRequestURI());
        return customerService.getAllCustomers();
    }
}
