package me.kafkadocker;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "TopicA", groupId = "my-consumer-group",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("📩 Получено сообщение: " + record.value());
        System.out.println("🔹 Из топика: " + record.topic());
        System.out.println("🔹 Offset: " + record.offset());
        System.out.println("🔹 Partition: " + record.partition());
    }
}
