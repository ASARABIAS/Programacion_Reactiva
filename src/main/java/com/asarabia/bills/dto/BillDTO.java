package com.asarabia.bills.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("bill")
@Builder(toBuilder = true)
public class BillDTO {
    @Id
    private Integer id;
    private String name;
    private String agreement;
    private String endDate;
    private Double amount;
    private String description;
    private String validationDataBase;
    private Boolean enabledToPay;
    private String status;
    private String refvalue;
    private String refname;
    private String acctId;
    private String acctTypeCode;
    private String acctTypeCodeDesc;
    private String identification;
    private String userName;
}
