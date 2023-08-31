package com.svalero.toprestaurantsapireactive.repository;

import com.svalero.toprestaurantsapireactive.domain.Restaurant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RestaurantRepository extends ReactiveMongoRepository<Restaurant, String> {

    Flux<Restaurant> findAll();
    Mono<Restaurant> findByName(String name);
}
