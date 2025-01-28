package com.MulitThreading.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.MulitThreading.entity.Vendor;
import com.MulitThreading.repository.VendorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SingletonService {
    private final VendorRepository vendorRepository;
    @Autowired
    public SingletonService(VendorRepository vr) {
    	this.vendorRepository = vr; 
    }


    @Async
    public void saveData(List<Vendor> vendors){
        
        if(vendors.size() > 0){
            log.info("Begin at: " + LocalDateTime.now());
            vendors.forEach(vendor -> { 
            	log.info("Async Service Thread: " + Thread.currentThread().getName());
                vendorRepository.save(vendor);
                try{
                    log.info("Thread Sleep 10 seconds." + " TimeStamp: " + LocalDateTime.now());
                    Thread.sleep(10000);
                }
                catch(InterruptedException e){
                    log.error("Error: "+e);     
                }
            });
        }

    }

    @Scheduled(fixedRate = 5000)
    public void displayData1() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Scheduled 1: " +  LocalDateTime.now());
        Thread.sleep(5*6*10000);
    }

    @Scheduled(fixedRate = 2000)
    public void displayData2() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Scheduled 2: " +  LocalDateTime.now());
        Thread.sleep(6*5*10000);
    }

    // @Scheduled(fixedRate = 3000)
    public void displayData3() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Scheduled 3: " +  LocalDateTime.now());
        Thread.sleep(6*5*10000);
    }


    
}
