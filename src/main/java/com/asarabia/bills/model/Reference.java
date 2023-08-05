package com.asarabia.bills.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Reference {
    @Id
    private String value;
    private String name;
}
