package com.bootcamp.entities;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.models.dto.BootcoinPurse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "buyBootcoinRequest")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

@Builder
public class BuyBootcoinRequest {
	
    @Id
    private String id;
    private double amount;
	private String paymentMethod;
	private String accountIdentifier;
	private BootcoinPurse buyerBootcoinPurse;
	private BootcoinPurse sellerBootcoinPurse;
	
  

}
