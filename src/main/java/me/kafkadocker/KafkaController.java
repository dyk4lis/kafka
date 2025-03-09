package me.kafkadocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8080/kafka/send?topic=TopicA&message=HelloKafka
    @GetMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        kafkaProducer.sendMessage(topic, message);
        return "✅ Сообщение отправлено в Kafka!";
    }
}
