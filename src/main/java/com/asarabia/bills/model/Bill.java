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

    @Override
    public String toString(){
        return "{\n" +
                "    \"name\": \""+this.name+"\",\n" +
                "    \"agreement\":\""+this.agreement+"\",\n" +
                "    \"endDate\": \""+this.endDate+"\",\n" +
                "    \"amount\": \""+this.amount+"\",\n" +
                "    \"description\": \""+this.description+"\",\n" +
                "    \"validationDataBase\": \""+this.validationDataBase+"\",\n" +
                "    \"status\": {\n" +
                "        \"enabledToPay\": \""+this.status.getEnabledToPay()+"\",\n" +
                "        \"value\":\""+this.status.getValue()+"\"\n" +
                "    },\n" +
                "    \"reference\":{\n" +
                "        \"value\": \""+this.reference.getValue()+"\",\n" +
                "        \"name\": \""+this.reference.getName()+"\"\n" +
                "    },\n" +
                "    \"bankAccount\": {\n" +
                "        \"acctId\": \""+this.bankAccount.getAcctId()+"\",\n" +
                "        \"acctTypeCode\":\""+this.bankAccount.getAcctTypeCode()+"\",\n" +
                "        \"acctTypeCodeDesc\": \""+this.bankAccount.getAcctTypeCodeDesc()+"\"\n" +
                "    },\n" +
                "    \"customer\": {\n" +
                "        \"identification\": \""+this.customer.getIdentification()+"\",\n" +
                "        \"name\": \""+this.customer.getName()+"\"\n" +
                "    }\n" +
                "}";
    }
}
