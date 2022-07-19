package com.example.api;

import com.example.service.Stock;
import org.springframework.messaging.handler.annotation.MessageMapping;
import reactor.core.publisher.Flux;

public interface StockService {

  @MessageMapping("stocks")
  Flux<Stock> getStocks();
}
