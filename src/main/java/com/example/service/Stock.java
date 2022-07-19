package com.example.service;

public class Stock {

  public String symbol;
  public String name;
  public long date;
  public double open;
  public double high;
  public double low;
  public double close;
  public double volume;

  public Stock( String symbol, String name, long date, double open,
                double high, double low, double close, double volume) {
    this.symbol = symbol;
    this.name = name;
    this.date = date;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
  }
}
