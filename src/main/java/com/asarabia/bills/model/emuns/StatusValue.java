package com.asarabia.bills.model.emuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusValue {
    INSCRITA("I", "Inscrita"),
    PROGRAMADA("A", "Programada"),
    PREINSCRITA("P", "Preinscrita"),
    RECHAZADA("R", "Rechazada");

    private final String key;
    private final String valor;
}
