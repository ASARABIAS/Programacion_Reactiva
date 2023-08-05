package com.asarabia.bills.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Customer {
    private String identification;
    private String name;
}
