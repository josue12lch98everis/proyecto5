package com.bootcamp.msCreateBootcoin.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bootcamp.entities.BuyBootcoinRequest;

import com.bootcamp.repositories.BuyBootcoinRequestRepository;
import com.bootcamp.msCreateBootcoin.services.IBootcoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BuyBootcoinServiceImpl implements IBootcoinService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyBootcoinServiceImpl.class);

 
    @Autowired
    private BuyBootcoinRequestRepository repository;

    @Override
    public Mono<BuyBootcoinRequest> create(BuyBootcoinRequest o) {
        return repository.save(o);
    }

    @Override
    public Flux<BuyBootcoinRequest> findAll() {
        return repository.findAll();
    }


	@Override
	public Mono<BuyBootcoinRequest> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}


	@Override
	public Mono<BuyBootcoinRequest> update(BuyBootcoinRequest o) {
		// TODO Auto-generated method stub
		return repository.save(o);
	}


	@Override
	public Mono<Void> delete(BuyBootcoinRequest o) {
		// TODO Auto-generated method stub
		return repository.delete(o);
	}


}