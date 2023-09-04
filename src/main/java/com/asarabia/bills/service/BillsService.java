package com.asarabia.bills.service;

import com.asarabia.bills.dto.BillDTO;
import com.asarabia.bills.model.*;
import com.asarabia.bills.model.emuns.StatusValue;
import com.asarabia.bills.model.emuns.ValidationDataBase;
import com.asarabia.bills.model.gateway.BillsGateway;
import com.asarabia.bills.repository.BillReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BillsService implements BillsGateway {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;
    private final BillReactiveRepository billReactiveRepository;

    public Flux<Bill> getBills() {
        return billReactiveRepository.findAll().map(BillsService::getBillFromBIllDTO);
    }

    public Flux<Bill> getBillsByCostumer(String identification) {
        return billReactiveRepository.findAllByIdentification(identification).map(BillsService::getBillFromBIllDTO);
    }

    public Mono<Bill> getBillByCostumerAndReferencePay(String identification, String referenceValue) {
        return billReactiveRepository.findAllByIdentificationAndRefValue(identification, referenceValue).map(BillsService::getBillFromBIllDTO);
    }

    public Mono<Bill> getBillById(Integer id) {
        return billReactiveRepository.findById(id).map(BillsService::getBillFromBIllDTO);
    }


    public Mono<Bill> inscribirBill(Bill bill) {
        kafkaProducerService.send("Bill-2023-09-02",bill.getReference().getValue(),bill);
        return billReactiveRepository.save(getBillDTOFromBill(bill)).map(BillsService::getBillFromBIllDTO);
    }

    public Mono<Void> deleteBill(Integer id) {
        return billReactiveRepository.deleteById(id);
    }

    public Mono<String> getLastBillKafka(String topico) {
        return Mono.just(kafkaConsumerService.ObtenerUltimoBill(topico));
    }

    private static BillDTO getBillDTOFromBill(Bill bill){
        return BillDTO.builder()
                .id(bill.getId())
                .name(bill.getName())
                .agreement(bill.getAgreement())
                .endDate(bill.getEndDate())
                .amount(bill.getAmount())
                .description(bill.getDescription())
                .validationDataBase(bill.getValidationDataBase().getKey())
                .enabledToPay(bill.getStatus().getEnabledToPay())
                .status(bill.getStatus().getValue().getKey())
                .refValue(bill.getReference().getValue())
                .refName(bill.getReference().getName())
                .acctId(bill.getBankAccount().getAcctId())
                .acctTypeCode(bill.getBankAccount().getAcctTypeCode())
                .acctTypeCodeDesc(bill.getBankAccount().getAcctTypeCodeDesc())
                .identification(bill.getCustomer().getIdentification())
                .userName(bill.getCustomer().getName())
                .build();
    }

    private static Bill getBillFromBIllDTO(BillDTO billDTO) {
        return Bill.builder()
                .id(billDTO.getId())
                .name(billDTO.getName())
                .agreement(billDTO.getAgreement())
                .endDate(billDTO.getEndDate())
                .amount(billDTO.getAmount())
                .description(billDTO.getDescription())
                .validationDataBase(getValidationDataBaseFromBIllDTO(billDTO.getValidationDataBase()))
                .status(Status.builder()
                        .enabledToPay(billDTO.getEnabledToPay())
                        .value(getStatusValueFromBIllDTO(billDTO.getStatus()))
                        .build())
                .reference(Reference.builder()
                        .name(billDTO.getRefName())
                        .value(billDTO.getRefValue())
                        .build())
                .bankAccount(BankAccount.builder()
                        .acctId(billDTO.getAcctId())
                        .acctTypeCode(billDTO.getAcctTypeCode())
                        .acctTypeCodeDesc(billDTO.getAcctTypeCodeDesc())
                        .build())
                .customer(Customer.builder()
                        .identification(billDTO.getIdentification())
                        .name(billDTO.getUserName())
                        .build())
                .build();
    }

    private static ValidationDataBase getValidationDataBaseFromBIllDTO(String validationDataBase){
        switch (validationDataBase){
            case "I": return ValidationDataBase.INTERNAL_VALIDATION;
            case "R": return ValidationDataBase.REDEBAN_VALIDATION;
            default: return ValidationDataBase.WITHOUT_VALIDATION;
        }
    }

    private static StatusValue getStatusValueFromBIllDTO(String statusValue){
        switch (statusValue){
            case "A": return StatusValue.PROGRAMADA;
            case "P": return StatusValue.PREINSCRITA;
            case "R": return StatusValue.RECHAZADA;
            default: return StatusValue.INSCRITA;
        }
    }
}
