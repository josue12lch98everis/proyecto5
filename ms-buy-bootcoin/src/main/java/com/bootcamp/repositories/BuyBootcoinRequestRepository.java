package com.bootcamp.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.entities.BuyBootcoinRequest;

import reactor.core.publisher.Mono;

public interface BuyBootcoinRequestRepository extends ReactiveMongoRepository<BuyBootcoinRequest,String> {
    
}
