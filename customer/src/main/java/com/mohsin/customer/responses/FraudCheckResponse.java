package com.mohsin.customer.responses;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class FraudCheckResponse {
    private Boolean isFraudulent;
}
