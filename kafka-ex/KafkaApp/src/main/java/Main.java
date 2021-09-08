import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AdminApp admin = new AdminApp();
        Publisher publisher = new Publisher();
        ConsumerApp consumer = new ConsumerApp();
        List<NewTopic> newTopics = new ArrayList<NewTopic>();
        for (int i = 1; i <= 3; i++) {
            NewTopic newTopic = new NewTopic("Topic" + i, 1, (short) 1);
            newTopics.add(newTopic);
        }

        List<ProducerRecord> messages = new ArrayList<ProducerRecord>();
        ProducerRecord<String, String> msg1 = new ProducerRecord<>("Topic1", null, "Asiakaslähtöisyys");
        ProducerRecord<String, String> msg2 = new ProducerRecord<>("Topic2", null, "Vastuullisuus");
        ProducerRecord<String, String> msg3 = new ProducerRecord<>("Topic3", null, "Uusiutuminen");
        ProducerRecord<String, String> msg4 = new ProducerRecord<>("Topic1", null, "Tuloksellisuus");
        ProducerRecord<String, String> msg5 = new ProducerRecord<>("Topic2", null, "Yhteistyö");
        messages.add(msg1);
        messages.add(msg2);
        messages.add(msg3);
        messages.add(msg4);
        messages.add(msg5);
        admin.createTopics(newTopics);
        publisher.sendMessages(messages);
        consumer.readMessages();
    }
}
