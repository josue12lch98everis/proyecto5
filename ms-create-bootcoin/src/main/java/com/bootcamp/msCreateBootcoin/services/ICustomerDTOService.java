package com.bootcamp.msCreateBootcoin.services;


import com.bootcamp.msCreateBootcoin.models.dto.CustomerDTO;

import reactor.core.publisher.Mono;

/**
 * The interface Customer dto service.
 */
public interface ICustomerDTOService {
    /**
     * Gets customer.
     *
     * @param customerIdentityNumber the customer identity number
     * @return the customer
     */
    public Mono<CustomerDTO> getCustomer(String customerIdentityNumber);
}
