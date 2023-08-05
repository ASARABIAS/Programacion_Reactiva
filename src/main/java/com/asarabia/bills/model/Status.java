package com.asarabia.bills.model;

import com.asarabia.bills.model.emuns.StatusValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Status {
    private Boolean enabledToPay;
    private StatusValue  value;
}
