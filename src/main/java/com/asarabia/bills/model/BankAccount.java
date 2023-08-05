package com.asarabia.bills.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BankAccount {
    @Id
    private String acctId;
    private String acctTypeCode;
    private String acctTypeCodeDesc;
}
