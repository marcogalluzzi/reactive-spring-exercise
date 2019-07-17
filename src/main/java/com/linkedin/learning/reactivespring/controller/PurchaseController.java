package com.linkedin.learning.reactivespring.controller;

import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping(value = "/{id}")
    public Mono<Purchase> getPurchase(@PathVariable("id") String id) {
        return coinBaseService.getPurchaseById(id);
    }

    @GetMapping(value = "/")
    public Flux<Purchase> getAllPurchases() {
        return coinBaseService.listaAllPurchases();
    }

}
