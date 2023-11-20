package pucrs.orderestimateservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableFeignClients
public class OrderEstimateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderEstimateServiceApplication.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("orders")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    @Profile("default") // Don't run from test(s)
    public ApplicationRunner runner() {
        return args -> {
            System.out.println("Hit Enter to terminate...");
            System.in.read();
        };
    }

}
