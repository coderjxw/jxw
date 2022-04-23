package com.example.jxw.controller;

import com.example.jxw.config.RedisService;
import com.example.jxw.entity.Car;
import com.example.jxw.service.impl.CarManagementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarManagementImpl carManagement;
    @Autowired
    private RedisService redisService;

    @GetMapping("/findAll")
    public List<Car> findAll() {
        return carManagement.findAllCarType();
    }

    @PostMapping("save")
    public Integer save(@RequestBody Car car) {
        Integer id = carManagement.save(car);
        redisService.set("car_" + id, car.toString());
        return id;
    }

    @GetMapping("/findById")
    public Car findById(@RequestParam Integer id) {
        return carManagement.findById(id);
    }

    @GetMapping("/findByIdCache")
    @Cacheable(value = "fruit1", key = "#param")
    public Car findByIdCache(@RequestParam Integer param) {
        return carManagement.findById(param);
    }



    @GetMapping("/findByIdCache3")
    public Car findByIdCache3(@RequestParam Integer param) {
        return carManagement.findById3(param);
    }
    @DeleteMapping("/deleteByIdCache")
    public Integer delteByIdCache(@RequestParam Integer param) {
        return carManagement.deleteById(param);
    }

    @GetMapping("/findAllByFilter")
    public List<Car> findAllByFilter(@RequestParam List<Integer> param, Integer filter) {
        return carManagement.findAllByIds(param, filter);
    }

}
