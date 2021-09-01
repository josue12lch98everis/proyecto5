package com.bootcamp.msCreateBootcoin.models.entities;


import com.bootcamp.msCreateBootcoin.models.dto.AccountsDTO;
import com.bootcamp.msCreateBootcoin.models.dto.CustomerDTO;
import com.bootcamp.msCreateBootcoin.models.dto.SavingAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "bootcoinPurse")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BootcoinPurse {

    @Id
    private String id;
    private String documentType;
    @NotNull
    private String customerIdentityNumber;
	private String phoneNumber;
	private String email;
	private Integer amountOfBootcoins;
	@Builder.Default
    private  Date createAt = new Date();
  
    
    

    
   
    
}
