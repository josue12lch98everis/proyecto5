//package com.bootcamp.msCreateBootcoin.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.bootcamp.msCreateBootcoin.consumer.EventConsumer;
//import com.bootcamp.msCreateBootcoin.events.TransactionYankiEvent;
//import com.bootcamp.msCreateBootcoin.events.YankiCreatedEvent;
//import com.bootcamp.msCreateBootcoin.models.dto.AddDebitCardEvent;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Sinks;
//
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//
//@Configuration
//public class CreateBootcoinService {
//
//
//  
//    private final EventConsumer<AddDebitCardEvent> addDebitCardEventConsumer;
//   
//    @Autowired
//    public CreateBootcoinService(EventConsumer<AddDebitCardEvent> addDebitCardEventConsumer) {
//    
//        this.addDebitCardEventConsumer=addDebitCardEventConsumer ;
//    }
//
//
//    @Bean
//    public Sinks.Many<AddDebitCardEvent> sink() {
//        return Sinks.many()
//                .multicast()
//                .directBestEffort();
//    }
//
//    @Bean
//    public Supplier<Flux<AddDebitCardEvent>> asociationDebitCardPublisher( //orderPurchaseEventPublisher
//            Sinks.Many<AddDebitCardEvent> publisher) {
//        return publisher::asFlux;
//    }
//	@Bean 
//	public Consumer<AddDebitCardEvent> asociationDebitCardProcessor(){
//		return addDebitCardEventConsumer::consumeEvent;	
//	}
// 
//
// 
//
//}
