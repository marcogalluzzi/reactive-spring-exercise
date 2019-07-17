package com.linkedin.learning.reactivespring.controller;

import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    @Autowired
    private CoinBaseService coinBaseService;

    @PostMapping(value = "/{name}")
    public Mono<Purchase> createPurchase(@PathVariable("name") String name) {
        // return Mono.fromSupplier(() -> new Purchase("name", "price", LocalDateTime.now()));
        return coinBaseService.createPurchase(name);
    }
}
