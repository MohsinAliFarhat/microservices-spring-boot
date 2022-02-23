package com.mohsin.customer;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class FraudCheckResponse {
    private Boolean isFraudulent;
}
