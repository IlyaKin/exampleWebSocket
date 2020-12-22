package com.example.config;

import com.example.domain.ExampleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.DateFormat;
import java.util.Date;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    Date date = new Date();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 3000L)
    private void sendItem() {
        template.convertAndSend("/topic", "test message");
        template.convertAndSend("/topic", new ExampleDTO(date.getDate(), "CurrentTime"));
    }

}

