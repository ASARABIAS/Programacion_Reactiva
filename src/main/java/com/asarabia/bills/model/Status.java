package com.asarabia.bills.model;

import com.asarabia.bills.model.emuns.StatusValue;
import lombok.Data;

@Data
public class Status {
    private Boolean enabledToPay;
    private StatusValue  value;
}
