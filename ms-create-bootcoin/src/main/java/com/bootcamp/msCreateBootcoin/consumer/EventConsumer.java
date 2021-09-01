package com.bootcamp.msCreateBootcoin.consumer;

import com.bootcamp.msCreateBootcoin.events.Event;

public interface EventConsumer<T extends Event> {
	  void consumeEvent(T event);
}
