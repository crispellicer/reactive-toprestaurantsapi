package com.svalero.toprestaurantsapireactive.service;

import com.svalero.toprestaurantsapireactive.domain.Restaurant;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface RestaurantService {
    Flux<Restaurant> findAll();
    Mono<Restaurant> findByName(String name);
    Mono<Restaurant> addRestaurant(Restaurant restaurant);
}
