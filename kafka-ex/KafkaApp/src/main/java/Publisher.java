import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;


public class Publisher {
    Producer producer;

    public Publisher() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        Producer<String, String> producer = new KafkaProducer<>(properties);
        this.producer = producer;
    }

    public void sendMessages() {
        String recordValue = "Does this work?";
        ProducerRecord<String, String> record = new ProducerRecord<>("Topic10", null, recordValue);
        producer.send(record);
        producer.flush();
    }
}