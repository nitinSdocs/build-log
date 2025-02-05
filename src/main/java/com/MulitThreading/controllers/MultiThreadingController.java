package com.MulitThreading.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MulitThreading.entity.Vendor;
import com.MulitThreading.services.SingletonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MultiThreadingController{
    private final SingletonService singletonService;
    
    
    @GetMapping("/async/save-data")
    public String serviceOne(@RequestBody List<Vendor> vendors){
    	log.info("Controller Thread: " + Thread.currentThread().getName());
        singletonService.saveData(vendors);
        return "Processing in Background.";
    } 

    @GetMapping("/async/method1")
    public String serviceTwo() throws InterruptedException{
        try{
            for(int i = 1; i <= 20; i++){
                singletonService.asyncMethod1(i);
            }
        }
        catch(Exception e){
            log.error("Error: " + e.getMessage());
        }
        return "Processing in Background.";
    }
    
}
