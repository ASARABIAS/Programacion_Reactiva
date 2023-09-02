package com.asarabia.bills.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("bill")
@Builder(toBuilder = true)
public class BillDTO {
    @Id
    private Integer id;
    @Column("name")
    private String name;
    @Column("agreement")
    private String agreement;
    @Column("end_date")
    private String endDate;
    @Column("amount")
    private Double amount;
    @Column("description")
    private String description;
    @Column("validation_data_base")
    private String validationDataBase;
    @Column("enabled_to_pay")
    private Boolean enabledToPay;
    @Column("status")
    private String status;
    @Column("ref_value")
    private String refValue;
    @Column("ref_name")
    private String refName;
    @Column("acct_id")
    private String acctId;
    @Column("acct_type_code")
    private String acctTypeCode;
    @Column("acct_type_code_desc")
    private String acctTypeCodeDesc;
    @Column("identification")
    private String identification;
    @Column("user_name")
    private String userName;
}
