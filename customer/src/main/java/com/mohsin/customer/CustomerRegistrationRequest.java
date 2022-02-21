package com.mohsin.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegistrationRequest {
    String firstName;
    String lastName;
    String email;
}
