package com.dariojolo.app.challengewenance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/prices")
public class PrecioRestController {

    @Autowired
    private PrecioBitconService service;

    @GetMapping
    public ResponseEntity<String> getPrice() {
        System.out.println("LLAMADA AL REST");
        Mono<String> precio = service.getbtcUsdPriceWebClient();
        if (precio == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println("FIN  REST ");
        return ResponseEntity.ok(precio.toString());
    }

}
