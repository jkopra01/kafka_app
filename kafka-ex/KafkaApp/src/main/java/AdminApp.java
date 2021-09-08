import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import java.util.List;
import java.util.Properties;

public class AdminApp {
    AdminClient adminClient;

    public AdminApp() {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        AdminClient adminClient = AdminClient.create(properties);
        this.adminClient = adminClient;
    }

    public void createTopics(List topics) {
        adminClient.createTopics(topics);
        adminClient.close();
    }
}
