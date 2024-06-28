package com.example.kafkaconsumer.Service;

import com.example.kafkaconsumer.Dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = "Object-topic1",groupId = "kafka-object1",
    topicPartitions = {@TopicPartition(topic = "Object-topic1",partitions = {"2"})}
    )
    public void consume(Customer customer){
        logger.info("Consumer consumed the msg : {} ",customer.toString());
    }
    @KafkaListener(topics = "Spring-topic",groupId = "kafka-demo")
    public void consume1(String msg){
        logger.info("Consumer1 consumed the msg : {} ",msg);
    }
    @KafkaListener(topics = "Spring-topic",groupId = "kafka-demo")
    public void consume2(String msg){
        logger.info("Consumer2 consumed the msg : {} ",msg);
    }
}
