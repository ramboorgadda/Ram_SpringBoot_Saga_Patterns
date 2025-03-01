package com.rksolutions.orderservice.config;

import com.rksolutions.commondto.dto.OrchestratorRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderConfig {
    @Bean
    public Sinks.Many<OrchestratorRequestDTO> sink(){
         return Sinks.many().unicast().onBackpressureBuffer();
    }
    public Flux<OrchestratorRequestDTO> flux(Sinks.Many<OrchestratorRequestDTO> sink){
        return sink.asFlux();
    }
}
