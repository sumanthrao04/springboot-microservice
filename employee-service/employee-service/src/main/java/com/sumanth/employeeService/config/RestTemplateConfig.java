package com.sumanth.employeeService.config;



import org.springframework.boot.web.client.RestTemplateBuilder; // builder for timeouts, base configs
import org.springframework.context.annotation.Bean;             // exposes a bean to Spring context
import org.springframework.context.annotation.Configuration;   // marks this as a config class
import org.springframework.web.client.RestTemplate;            // the HTTP client
import org.springframework.web.reactive.function.client.WebClient;


@Configuration                                                 // Spring will scan this class
public class RestTemplateConfig {

    @Bean // Exposes a singleton RestTemplate in the Spring context
    public RestTemplate restTemplate() {
        return new RestTemplate(); // Basic RestTemplate without custom settings
    }

    @Bean
    public WebClient webClient(){
        return   WebClient.builder().build() ;
    }
}
