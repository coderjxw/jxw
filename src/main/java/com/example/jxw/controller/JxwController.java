package com.example.jxw.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/jxw")
public class JxwController {

    @Value("${service.port:}")
    private String nacosConfig;




    @GetMapping("/jxw1")
    public void jxw1(@RequestParam int id){
        System.out.println("1:"+nacosConfig );

    }
}
