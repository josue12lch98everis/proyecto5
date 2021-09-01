package com.bootcamp.msCreateBootcoin.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.msCreateBootcoin.models.entities.BootcoinPurse;

import reactor.core.publisher.Mono;

public interface BootcoinPurseRepository extends ReactiveMongoRepository<BootcoinPurse,String> {
    
}
