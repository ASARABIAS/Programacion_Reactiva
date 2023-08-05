package com.asarabia.bills.model.gateway;

import com.asarabia.bills.model.Bill;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillsGateway {
    Flux<Bill> getBills(String identification);
    Mono<Bill> getBillByReferencePay(String identification, String referenceValue );
    Mono<Bill> getBillById(String identification, Integer id );
    Mono<Bill> inscribirBill(Bill bill);
    Mono<Void> deleteBill(Integer id);
}
