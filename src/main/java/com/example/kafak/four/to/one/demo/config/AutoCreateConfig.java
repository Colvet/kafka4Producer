package com.example.kafak.four.to.one.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("local")
public class AutoCreateConfig {
    @Bean
    public NewTopic fileEvents(){
        return TopicBuilder.name("file-events")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
