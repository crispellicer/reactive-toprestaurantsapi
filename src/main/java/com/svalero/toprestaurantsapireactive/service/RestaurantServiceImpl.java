package com.svalero.toprestaurantsapireactive.service;

import com.svalero.toprestaurantsapireactive.domain.Restaurant;
import com.svalero.toprestaurantsapireactive.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Flux<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Mono<Restaurant> findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Mono<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
