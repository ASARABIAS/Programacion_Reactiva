package com.asarabia.bills.service;

import com.asarabia.bills.config.KafkaConfig;
import com.asarabia.bills.model.Bill;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
public class KafkaConsumerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    private KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaConsumerService(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public String ObtenerUltimoBill(String topico){
        ConsumerRecord<String, Object> ultimoFactura;
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaTemplate.setConsumerFactory(kafkaConfig.consumerFactory());
        ultimoFactura = kafkaTemplate.receive(topico, 0, 0);
        String billRecibido = ultimoFactura.value().toString();
        return  billRecibido;
    }
}
