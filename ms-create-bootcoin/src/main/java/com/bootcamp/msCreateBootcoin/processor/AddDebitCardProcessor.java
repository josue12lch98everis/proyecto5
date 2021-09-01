package com.bootcamp.msCreateBootcoin.processor;


import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.msCreateBootcoin.models.dto.AddDebitCardEvent;

import reactor.core.publisher.Sinks;

public class AddDebitCardProcessor {

    private final Sinks.Many<AddDebitCardEvent> sink;

    @Autowired
    public AddDebitCardProcessor(Sinks.Many<AddDebitCardEvent> sink) {
        this.sink = sink;
    }

    public void consume(String cardNumber, AddDebitCardEvent addDebitCardEvent) {
      
        //TODO procesar 
        
        sink.emitNext(addDebitCardEvent, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
