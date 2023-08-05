package com.asarabia.bills.model.emuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationDataBase {
    WITHOUT_VALIDATION("N", "Sin Validación"),
    INTERNAL_VALIDATION("I", "Validación Interna"),
    REDEBAN_VALIDATION("R", "Validación Redeban");

    private final String key;
    private final String valor;
}
