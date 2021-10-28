package com.example.jxw.service;

import com.example.jxw.entity.Car;

import java.util.List;

public interface CarManagement {

    public  List<Car> findAllCarType();

    public Integer save(Car car);

    public Car findById(Integer id);

    public Integer deleteById(Integer id);

    public Car findById3(Integer id);

    public List<Car> findAllByIds(List<Integer> ids,Integer filter);
}
