package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener("${kafka.group}")
public class Client {
 private static Logger log = LoggerFactory.getLogger(Client.class);

    @Topic("${topic.chat}")
    public void receive(ConsumerRecord<String, String> record){
        log.debug("{}-{}:{} {}", record.topic(), record.partition(), record.offset(), record.value());

    }
    
}
