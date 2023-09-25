package com.asarabia.bills.controller.seguimiento_3;

import com.asarabia.bills.model.Bill;
import com.asarabia.bills.model.gateway.BillsGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/bills", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BillsControllerPunto1 {
    private final BillsGateway billsGateway;

    @PostMapping
    public Mono<Bill> inscribirBill(@RequestBody Bill bill){
        return billsGateway.inscribirBill(bill);
    }

    @GetMapping("{identification}/{referenceValue}")
    public Mono<Bill> getBillByCostumerAndReferencePay(@PathVariable("identification") String identification, @PathVariable("referenceValue") String referenceValue ){
        return billsGateway.getBillByCostumerAndReferencePay(identification, referenceValue);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteBill(@PathVariable("id") Integer id){
        return billsGateway.deleteBill(id);
    }

}
