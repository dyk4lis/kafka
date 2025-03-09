package me.kafkadocker;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {
    @KafkaListener(topics = "TopicA", groupId = "my-consumer-group",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
        System.out.println("📩 Получено сообщение: " + record.value());
        System.out.println("🔹 Из топика: " + record.topic());
        System.out.println("🔹 Offset: " + record.offset());
        System.out.println("🔹 Partition: " + record.partition());

        // ручное подтверждение, обычно используется ContainerProperties.AckMode.RECORD
        acknowledgment.acknowledge();
    }
}
