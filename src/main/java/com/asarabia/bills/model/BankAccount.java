package com.asarabia.bills.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BankAccount {
    private String acctId;
    private String acctTypeCode;
    private String acctTypeCodeDesc;
}
