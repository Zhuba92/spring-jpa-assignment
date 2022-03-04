package com.example.springjpa.service;

import com.example.springjpa.entity.Candle;

import java.util.List;

public interface CandleServiceInterface {
    List<Candle> getCandleList();
    Candle getCandle(int id);
    Candle getCandle(String name);

    void purchase(int id, int amount);
}
