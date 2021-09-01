package com.bootcamp.msCreateBootcoin.controller;



import java.awt.Adjustable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.msCreateBootcoin.models.dto.AccountsDTO;
import com.bootcamp.msCreateBootcoin.models.dto.DebitAccountDTO;
import com.bootcamp.msCreateBootcoin.models.dto.RetireDTO;
import com.bootcamp.msCreateBootcoin.models.entities.BootcoinPurse;
import com.bootcamp.msCreateBootcoin.processor.YankiDebitCardProcessor;
import com.bootcamp.msCreateBootcoin.services.IDebitAccountDTOService;
import com.bootcamp.msCreateBootcoin.services.IBootcoinService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping()
public class CreateBootcoinController {


	 private static final Logger LOGGER = LoggerFactory.getLogger(CreateBootcoinController.class);
	@Autowired 
	YankiDebitCardProcessor yankiDebitCardProcessor;
	 @Autowired
		private IBootcoinService bootcoinService;
		
	
		@GetMapping()
		public Flux<BootcoinPurse> getAllBootcoins() {
			
			Flux<BootcoinPurse> bootCoins = bootcoinService.findAll().map(bootcoin -> {
				return bootcoin;
			});
			return bootCoins;
		}
		
		@PostMapping()
		public Mono<BootcoinPurse> saveDebitCard(@RequestBody BootcoinPurse bootcoin) {
		
			
			Mono<BootcoinPurse> bootcoinCreate = bootcoinService.create(bootcoin);
			return bootcoinCreate;
		
		}
		
		@PostMapping("/payProduct")
		public Mono<BootcoinPurse> payProductDebitCard(@RequestBody BootcoinPurse bootcoin, double amountOfDebit) {
			
		
			return null;
			
		}
		
		
	
			 
			 
	


		@DeleteMapping("/{pan}")
		public Mono<Void> deleteByID(@PathVariable(name="id",required= true) String id) {
		
		return	bootcoinService.findById(id).flatMap(a->bootcoinService.delete(a) ).switchIfEmpty(null);
		
			
		}
//		@GetMapping("findByPan/{pan}")
//		public Mono<BootcoinPurse> findByID(@PathVariable(name="pan",required= true) String pan) {
//		
//		return	bootcoinService.findByPan(pan);
//			
//			}
//		
//	
//		@GetMapping("/deposit/{pan}/{amount}")
//		public Mono<RetireDTO> retire(@PathVariable(name="pan",required= true) String pan, 
//				@PathVariable(name="amount",required = true) double amount) {
//			
//			Comparator<AccountsDTO> comparador = Comparator.comparing(AccountsDTO::getOrder);
//			 Flux<AccountsDTO> accounts=bootcoinService.findByPan(pan).flatMapMany(a ->	
//			  Flux.fromStream( a.getAccounts().stream().sorted(comparador)) ) ;
//			 
//		
//			 
//		return	 accounts.flatMap( mainAccount-> debitAccountDTOService.
//				findByAccountNumber(  mainAccount.getTypeOfAccount(), mainAccount.getNumberOfAccount())).
// filter(account->account.getAmount()>amount).limitRequest(1).
// flatMap(debitAccount->  bootcoinService.retire
//		 ( RetireDTO.builder()
//				 .accountNumber(debitAccount.getAccountNumber())
//				 .amount(amount)
//				 .typeOfAccount(debitAccount.getTypeOfAccount())
//				 .build()  )).next().defaultIfEmpty(null) ;
//		}
		
		
//		@GetMapping("/getMainAccount/{pan}")
//		public Mono<DebitAccountDTO> getMainAccount(@PathVariable(name="pan",required= true) String pan ) {
//			
//			return bootcoinService.getMainAccountFromDebitCard(pan).doOnSuccess(acc-> {
//				yankiDebitCardProcessor.process(acc, pan);
//				
//				
//			});
//		}
		
}
	


