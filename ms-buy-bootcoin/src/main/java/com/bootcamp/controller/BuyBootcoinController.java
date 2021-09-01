package com.bootcamp.controller;



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

import com.bootcamp.entities.BuyBootcoinRequest;
import com.bootcamp.models.dto.AccountsDTO;
import com.bootcamp.models.dto.BootcoinPurse;
import com.bootcamp.models.dto.DebitAccountDTO;
import com.bootcamp.models.dto.RetireDTO;
import com.bootcamp.msCreateBootcoin.services.IBootcoinService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping()
public class BuyBootcoinController {


	 private static final Logger LOGGER = LoggerFactory.getLogger(BuyBootcoinController.class);
	 IBootcoinService bootcoinService;
	
		@GetMapping()
		public Flux<BuyBootcoinRequest> getAllBootcoins() {
			
			Flux<BuyBootcoinRequest> bootCoins = bootcoinService.findAll().map(bootcoin -> {
				return bootcoin;
			});
			return bootCoins;
		}
		
		@PostMapping()
		public Mono<BuyBootcoinRequest> saveBuyBootcoinRequest(@RequestBody BuyBootcoinRequest bootcoin) {
		
			
			Mono<BuyBootcoinRequest> bootcoinCreate = bootcoinService.create(bootcoin);
			return bootcoinCreate;
		
		}
		
		@PostMapping("/buy")
		public Mono<BuyBootcoinRequest> aceptBuyRequest2(@RequestBody BootcoinPurse bootcoinPurse,@RequestParam String bootcoinPurseId) {
		
			Mono<BuyBootcoinRequest> bootcoinCreate = bootcoinService.findById(bootcoinPurseId).flatMap(a->{
				a.setSellerBootcoinPurse(bootcoinPurse);
				return Mono.just(a);
			}); 
			
			return bootcoinCreate.doOnSuccess(null);
		
		}
		
		@PostMapping("/payProduct")
		public Mono<BuyBootcoinRequest> payProductDebitCard(@RequestBody BuyBootcoinRequest bootcoin, double amountOfDebit) {
			
		
			return null;
			
		}
		
		
	
			 
			 
	


		@DeleteMapping("/{pan}")
		public Mono<Void> deleteByID(@PathVariable(name="id",required= true) String id) {
		
		return	bootcoinService.findById(id).flatMap(a->bootcoinService.delete(a) ).switchIfEmpty(null);
		
			
		}
//		@GetMapping("findByPan/{pan}")
//		public Mono<BuyBootcoinRequest> findByID(@PathVariable(name="pan",required= true) String pan) {
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
	


