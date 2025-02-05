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
    public void asyncMethod1(int i) throws InterruptedException{
        log.info("Task number: " + i);
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Async Method 1: " +  LocalDateTime.now());
        Thread.sleep(20*1000);
    }

    @Async
    public void asyncMethod2() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Async Method 2: " +  LocalDateTime.now());
        Thread.sleep(10*1000);
    }

    @Async
    public void asyncMethod3() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Async Method 3: " +  LocalDateTime.now());
        Thread.sleep(10*1000);
    }

    @Async
    public void asyncMethod4() throws InterruptedException{
        log.info("Thread Name: " + Thread.currentThread().getName());
        log.info("Async Method 4: " +  LocalDateTime.now());
        Thread.sleep(10*1000);
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

//    // @Async("ExecutorForScheduled")
//     // @Async
//     @Scheduled(fixedDelay  = 10000)
//   // @Scheduled(cron = "0/1 * * ? * *")
//     public void displayData1() throws InterruptedException{
//         log.info("Thread Name: " + Thread.currentThread().getName());
//         log.info("Scheduled 1: " +  LocalDateTime.now());
//         Thread.sleep(10*1000);
//     }

//    // @Async("ExecutorForScheduled")
//     // @Async
//     @Scheduled(fixedDelay = 20000)
//    //@Scheduled(cron = "0/2 * * ? * *")
//     public void displayData2() throws InterruptedException{
//         log.info("Thread Name: " + Thread.currentThread().getName());
//         log.info("Scheduled 2: " +  LocalDateTime.now());
//         Thread.sleep(10*1000);

//     }

//      @Scheduled(fixedDelay = 30000)
//     //@Scheduled(cron = "0/7 * * ? * *")
//     public void displayData3() throws InterruptedException{
//         log.info("Thread Name: " + Thread.currentThread().getName());
//         log.info("Scheduled 3: " +  LocalDateTime.now());
//         Thread.sleep(10*1000);
//     }

//     @Scheduled(fixedDelay = 40000)
//     //@Scheduled(cron = "0/7 * * ? * *")
//     public void displayData4() throws InterruptedException{
//         log.info("Thread Name: " + Thread.currentThread().getName());
//         log.info("Scheduled 4: " +  LocalDateTime.now());
//         Thread.sleep(10*1000);
//     }


    
}
