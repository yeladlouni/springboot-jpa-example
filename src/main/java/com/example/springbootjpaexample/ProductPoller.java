package com.example.springbootjpaexample;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component

public class ProductPoller {
    private final ProductRepository repository;
    private WebClient client = WebClient.create("http://localhost:7654/products");

    ProductPoller(ProductRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollProducts() {
        repository.deleteAll();

        client.get()
                .retrieve()
                .bodyToFlux(Product.class)
                .filter(product -> !product.getLabel().isEmpty())
                .toStream()
                .forEach(repository::save);

        repository.findAll().forEach(System.out::println);
    }
}
