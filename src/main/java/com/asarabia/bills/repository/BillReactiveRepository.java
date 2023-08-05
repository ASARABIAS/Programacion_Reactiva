package com.asarabia.bills.repository;

import com.asarabia.bills.dto.BillDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillReactiveRepository extends ReactiveCrudRepository<BillDTO, Integer> {
    Flux<BillDTO> findAllByIdentification(String identification);
    Mono<BillDTO> findAllByIdentificationAndRefvalue(String identification, String refvalue);
}
