package com.cts.microservicesexe2.resilience;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/my-service")
    public Mono<String> myServiceFallback() {
        return Mono.just("My Service is currently unavailable. Please try again later.");
    }
}

