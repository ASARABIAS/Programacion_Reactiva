package com.asarabia.bills.controller.seguimiento_3.v2;

import com.asarabia.bills.model.Bill;
import com.asarabia.bills.model.gateway.BillsGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/v2/bills", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BillsControllerPunto2 {
    private final BillsGateway billsGateway;


    @GetMapping("/enabledToPay")
    public Flux<Bill> getBillByEnabledToPay(){
        return billsGateway.getBillByCostumerAndReferencePay();
    }


}
