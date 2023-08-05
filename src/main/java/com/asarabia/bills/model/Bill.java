package com.asarabia.bills.model;

import com.asarabia.bills.model.emuns.ValidationDataBase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Bill {
    private Integer id;
    private String name;
    private String agreement;
    private String endDate;
    private Double amount;
    private String description;
    private ValidationDataBase validationDataBase;
    private Status status;
    private Reference reference;
    private BankAccount bankAccount;
    private Customer customer;
}
