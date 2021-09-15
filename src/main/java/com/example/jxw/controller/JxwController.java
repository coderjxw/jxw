package com.example.jxw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jxw")
public class JxwController {

    @GetMapping("/jxw1")
    public void jxw1(@RequestParam int id){
        System.out.println("id is : " + id);
    }
}
