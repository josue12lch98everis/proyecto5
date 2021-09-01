package com.bootcamp.msCreateBootcoin.models.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import com.bootcamp.msCreateBootcoin.events.Event;

@Builder
@Data
public class AddDebitCardEvent implements Event{

    private static final String EVENT = "YankiAccountCreated";
    private BigDecimal yankiBalance;
    private String yankiAccountId;
    private String  debitCardNumber;

    @Override
    public String getEvent() {
        return EVENT;
    }
}
