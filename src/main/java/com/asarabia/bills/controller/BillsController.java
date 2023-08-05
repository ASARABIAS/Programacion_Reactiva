package com.asarabia.bills.controller;

import com.asarabia.bills.model.Bill;
import com.asarabia.bills.model.gateway.BillsGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/bills", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BillsController {
    private final BillsGateway billsGateway;

    @GetMapping("{identification}")
    public Flux<Bill> getBills(@PathVariable("identification") String identification ){
        return billsGateway.getBills(identification);
    }

    @GetMapping("{identification}/{referenceValue}")
    public Mono<Bill> getBillByReferencePay(@PathVariable("identification") String identification, @PathVariable("referenceValue") String referenceValue ){
        return billsGateway.getBillByReferencePay(identification, referenceValue);
    }

    @GetMapping("{identification}/{id}")
    public Mono<Bill> getBillById(@PathVariable("identification") String identification, @PathVariable("referenceValue") Integer id ){
        return billsGateway.getBillById(identification, id);
    }

    @PostMapping
    public Mono<Bill> inscribirBill(@RequestBody Bill bill){
        return billsGateway.inscribirBill(bill);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteBill(@PathVariable("id") Integer id){
        return billsGateway.deleteBill(id);
    }
}
