package com.bootcamp.msCreateBootcoin.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bootcamp.msCreateBootcoin.models.dto.AccountsDTO;
import com.bootcamp.msCreateBootcoin.models.dto.CustomerDTO;
import com.bootcamp.msCreateBootcoin.models.dto.DebitAccountDTO;
import com.bootcamp.msCreateBootcoin.models.dto.RetireDTO;
import com.bootcamp.msCreateBootcoin.models.entities.BootcoinPurse;
import com.bootcamp.msCreateBootcoin.repositories.BootcoinPurseRepository;
import com.bootcamp.msCreateBootcoin.services.IDebitAccountDTOService;
import com.bootcamp.msCreateBootcoin.services.IBootcoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BootcoinServiceImpl implements IBootcoinService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootcoinServiceImpl.class);

 
    @Autowired
    private BootcoinPurseRepository repository;

    @Override
    public Mono<BootcoinPurse> create(BootcoinPurse o) {
        return repository.save(o);
    }

    @Override
    public Flux<BootcoinPurse> findAll() {
        return repository.findAll();
    }


	@Override
	public Mono<BootcoinPurse> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}


	@Override
	public Mono<BootcoinPurse> update(BootcoinPurse o) {
		// TODO Auto-generated method stub
		return repository.save(o);
	}


	@Override
	public Mono<Void> delete(BootcoinPurse o) {
		// TODO Auto-generated method stub
		return repository.delete(o);
	}


}