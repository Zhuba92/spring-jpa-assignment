package com.example.springjpa.service;

import com.example.springjpa.repo.CandleRepository;
import com.example.springjpa.entity.Candle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandleService implements CandleServiceInterface {
    private CandleRepository candleRepository;

    @Autowired
    public CandleService(CandleRepository candleRepository) {
        this.candleRepository = candleRepository;
    }

    @Override
    public List<Candle> getCandleList() {
        return candleRepository.findAllByOrderById();
    }

    @Override
    public Candle getCandle(int id) {
        Optional<Candle> c = candleRepository.findById(id);
        return c.orElse(null);
    }

    @Override
    public Candle getCandle(String name) {
        Candle ca = null;
        for (int i = 0; i < candleRepository.count(); i++) {
            if (candleRepository.findAllByOrderById().get(i).getName().equalsIgnoreCase(name)) {
                ca = candleRepository.findAllByOrderById().get(i);
            };
        }
        return ca;
    }

    @Override
    public void purchase(int id, int amount) {
        Candle item = getCandle(id);
        if (item != null && item.getQuantity() >= amount) {
            item.setQuantity(item.getQuantity() - amount);
            candleRepository.save(item);
        }
    }

}


