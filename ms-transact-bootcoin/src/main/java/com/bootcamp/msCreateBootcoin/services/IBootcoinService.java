package com.bootcamp.msCreateBootcoin.services;

import com.bootcamp.msCreateBootcoin.models.dto.AccountsDTO;
import com.bootcamp.msCreateBootcoin.models.dto.CustomerDTO;
import com.bootcamp.msCreateBootcoin.models.dto.DebitAccountDTO;
import com.bootcamp.msCreateBootcoin.models.dto.RetireDTO;
import com.bootcamp.msCreateBootcoin.models.entities.BootcoinPurse;

import reactor.core.publisher.Mono;

public interface IBootcoinService extends ICRUDService<BootcoinPurse,String> {

//    public Mono<CustomerDTO> getCustomer(String customerIdentityNumber);
//    
//    public Mono<CustomerDTO> newPan(String id, CustomerDTO customerDTO);
//    public Mono<RetireDTO> retire( RetireDTO retire) ;
//    




}
