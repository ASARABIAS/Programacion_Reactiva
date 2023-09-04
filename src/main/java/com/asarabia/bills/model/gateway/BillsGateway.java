package com.asarabia.bills.model.gateway;

import com.asarabia.bills.model.Bill;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillsGateway {

    Flux<Bill> getBills();
    Flux<Bill> getBillsByCostumer(String identification);
    Mono<Bill> getBillByCostumerAndReferencePay(String identification, String referenceValue );
    Mono<Bill> getBillById(Integer id );
    Mono<Bill> inscribirBill(Bill bill);
    Mono<Void> deleteBill(Integer id);
    Mono<String> getLastBillKafka(String topico);
}
