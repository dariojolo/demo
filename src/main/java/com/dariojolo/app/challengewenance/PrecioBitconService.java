package com.dariojolo.app.challengewenance;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PrecioBitconService {

    public Mono<String> getbtcUsdPriceWebClient() {
        System.out.println("LLAMADA AL WEB CLIENT");
        return WebClient.create("http://cex.io/api/last_price/BTC")
                .get()
                .uri(uriBuilder -> uriBuilder
                .path("/USD").build())
                .accept(MediaType.ALL)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.just(new Exception (response.statusCode().toString())))
                .bodyToMono(String.class)
                .log("error obteniendo precio")
                .onErrorResume(throwable -> {
                    return Mono.error(new Exception ("FALLO " + HttpStatus.NOT_FOUND));
                });

    }
}
