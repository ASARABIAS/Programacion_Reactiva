package com.asarabia.bills.service;

import com.asarabia.bills.model.Bill;
import com.asarabia.bills.model.gateway.BillsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BillsService implements BillsGateway {
    public Flux<Bill> getBills(String identification) {
        return null;
    }

    public Mono<Bill> getBillByReferencePay(String identification, String referenceValue) {
        return null;
    }

    public Mono<Bill> getBillById(String identification, Integer id) {
        return null;
    }

    public Mono<Bill> inscribirBill(Bill bill) {
        return null;
    }

    public Mono<Void> deleteBill(Integer id) {
        
        return null;
    }
}
