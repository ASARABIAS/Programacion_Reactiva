package com.asarabia.bills.service;

import com.asarabia.bills.model.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topico, String key, Bill bill){
        var future = kafkaTemplate.send(topico, key, bill.toString());

        future.whenComplete((resultadoEnvio, excepcion)->{
           if(excepcion != null){
               future.completeExceptionally(excepcion);
           }else {
               future.complete(resultadoEnvio);
           }
           LOGGER.info("Factura enviado al topico de kafka" + bill);
        });
    }
}
