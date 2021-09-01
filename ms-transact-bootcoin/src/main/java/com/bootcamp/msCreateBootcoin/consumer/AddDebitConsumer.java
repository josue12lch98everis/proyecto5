package com.bootcamp.msCreateBootcoin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.msCreateBootcoin.models.dto.AddDebitCardEvent;
import com.bootcamp.msCreateBootcoin.repositories.BootcoinPurseRepository;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class AddDebitConsumer implements EventConsumer<AddDebitCardEvent>{
	
		@Autowired
	    private BootcoinPurseRepository repository;
		 @Override
		    public void consumeEvent(AddDebitCardEvent event) {
			 log.info("===========Receiving request for associated DebitCard========= : {}", event);

		        
		      
		    }
	


}
