package com.asarabia.bills.controller;

import com.asarabia.bills.model.Bill;
import com.asarabia.bills.model.gateway.BillsGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/user/bills", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BillsController {
    private final BillsGateway billsGateway;

    @GetMapping
    public Flux<Bill> getBills( ){
        return billsGateway.getBills();
    }

    @GetMapping("{identification}")
    public Flux<Bill> getBillsByCostumer(@PathVariable("identification") String identification ){
        return billsGateway.getBillsByCostumer(identification);
    }

    @GetMapping("search/{id}")
    public Mono<Bill> getBillById(@PathVariable("id") Integer id ){
        return billsGateway.getBillById(id);
    }

    /*
    @PostMapping
    public Mono<Bill> inscribirBill(@RequestBody Bill bill){
        return billsGateway.inscribirBill(bill);
    }
    */
    /*
    @DeleteMapping("{id}")
    public Mono<Void> deleteBill(@PathVariable("id") Integer id){
        return billsGateway.deleteBill(id);
    }
    */
    //

    @GetMapping("getLastBillKafka/{topico}")
    public Mono<String> getLastBillKafka (@PathVariable("topico") String topico ){
        return billsGateway.getLastBillKafka(topico);
    }
}
