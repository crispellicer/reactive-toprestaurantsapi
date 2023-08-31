package com.svalero.toprestaurantsapireactive.controller;

import com.svalero.toprestaurantsapireactive.domain.Restaurant;
import com.svalero.toprestaurantsapireactive.exception.RestaurantNotFoundException;
import com.svalero.toprestaurantsapireactive.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Restaurant> getRestaurants() {
        return restaurantService.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/restaurants/{name}")
    private Mono<ResponseEntity<Restaurant>> getIsbn(@PathVariable("name") String name) throws RestaurantNotFoundException {
        return this.restaurantService.findByName(name)
                .flatMap(restaurant -> Mono.just(ResponseEntity.ok(restaurant)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping(value = "/restaurants")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant).block();
    }
}
