package com.linkedin.learning.reactivespring.controller;

import com.linkedin.learning.reactivespring.model.Purchase;
import com.linkedin.learning.reactivespring.service.CoinBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseHandler {

    @Autowired
    private CoinBaseService coinBaseService;

    public Mono<ServerResponse> listPurchases(ServerRequest serverRequest) {
        // final Mono<Purchase> purchase = Mono.fromSupplier(() -> new Purchase("Form Functional Endpoint", "123", LocalDateTime.now()));
        final Mono<Purchase> purchase = coinBaseService.getPurchaseById(serverRequest.pathVariable("id"));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, Purchase.class);
    }

    public Mono<ServerResponse> listAllPurchases(ServerRequest serverRequest) {
        final Flux<Purchase> purchaseFlux = coinBaseService.listaAllPurchases();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(purchaseFlux.collectList(), new ParameterizedTypeReference<List<Purchase>>(){});
    }
}
