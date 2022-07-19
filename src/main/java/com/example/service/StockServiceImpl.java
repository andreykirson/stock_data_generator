package com.example.service;

import com.example.api.StockService;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

@Controller
public class StockServiceImpl implements StockService
{
  @Override
  public Flux<Stock> getStocks()
  {
    return Flux.range(0, 1).delaySequence(Duration.ofSeconds(1)).flatMap(i -> getStock("Tesla Inc", "Tesla Motors, Inc."))
        .log().repeat(Long.MAX_VALUE); // generate data every second
  }

  private static Flux<Stock> getStock(String symbol, String name)
  {
    double openDouble = new Random().nextDouble(0.01, 100_000);

    double close  = new Random().nextDouble(0.01, 100_000);
    double high   = Math.max(new Random().nextDouble(0.01, 100_000), openDouble);
    double low    = Math.min(new Random().nextDouble(0.01, 100_000), openDouble);
    double volume = new Random().nextInt(1, 100_000_000);
    long   date   = new Date().toInstant().toEpochMilli();

    return Flux.just(new Stock(symbol, name, date, openDouble, high, low, close, volume));
  }
}
