package com.example.springjpa.repo;

import com.example.springjpa.entity.Candle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandleRepository extends CrudRepository<Candle, Integer> {
    List<Candle> findAllByOrderById();
}
