package com.asarabia.bills.controller;

import com.asarabia.bills.model.*;
import com.asarabia.bills.model.emuns.StatusValue;
import com.asarabia.bills.model.emuns.ValidationDataBase;
import com.asarabia.bills.model.gateway.BillsGateway;
import com.asarabia.bills.service.BillsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest
@ContextConfiguration(classes = {BillsController.class})
class BillsControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private BillsGateway billsGateway;

    @InjectMocks
    private BillsController billsController;

    @Mock
    BillsService billsService;

    @BeforeEach
    public void init() {
        webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();
    }

   @Test
    void whenTheBillsAreRequested_TheyAreObtainedSuccessfully(){
       Bill billData = Bill.builder()
               .id(1)
               .name("Nombre Convenio")
               .agreement("12345")
               .endDate("20/08/2023")
               .amount(100.0)
               .description("Factura prueba")
               .validationDataBase(ValidationDataBase.WITHOUT_VALIDATION)
               .status(Status.builder()
                       .enabledToPay(true)
                       .value(StatusValue.INSCRITA)
                       .build())
               .reference(Reference.builder()
                       .name("Pago Cedula")
                       .value("123456")
                       .build())
               .bankAccount(BankAccount.builder()
                       .acctId("123-456-789")
                       .acctTypeCode("7")
                       .acctTypeCodeDesc("Cuenta Ahorro")
                       .build())
               .customer(Customer.builder()
                       .identification("1234567890")
                       .name("Data Prueba")
                       .build())
               .build();

       when(billsController.getBills()) .thenReturn((Flux.just(billData)));

       webTestClient.get()
               .uri("/api/bills" )
               .exchange()
               .expectStatus()
               .is2xxSuccessful();


   }


}
