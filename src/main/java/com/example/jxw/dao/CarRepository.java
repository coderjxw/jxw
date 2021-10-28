package com.example.jxw.dao;

import com.example.jxw.entity.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Override
    @Cacheable(value = "CarRepository.findById", key ="#id")
    Optional<Car> findById(Integer id);
}
