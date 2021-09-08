import org.apache.kafka.clients.admin.NewTopic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AdminApp admin = new AdminApp();
        Publisher publisher = new Publisher();
        ConsumerApp consumer = new ConsumerApp();
        List<NewTopic> newTopics = new ArrayList<NewTopic>();
        for (int i = 10; i <= 13; i++) {
            NewTopic newTopic = new NewTopic("Topic" + i, 1, (short) 1);
            newTopics.add(newTopic);
        }
        admin.createTopics(newTopics);
        publisher.sendMessages();
        consumer.readMessages();
    }
}
