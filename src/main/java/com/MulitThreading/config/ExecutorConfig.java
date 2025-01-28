package com.MulitThreading.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ExecutorConfig {
	
	//   @Bean 
    //   public Executor threadPoolExecutor() { 
	//     ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
	//     executor.setThreadNamePrefix("Executor thread: "); 
    //     return executor;
	//   }

    // @Bean
    // public Executor customThreadPoolExecutor() {
    //     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    //     executor.setCorePoolSize(16);
    //     executor.setThreadNamePrefix("Executor thread: ");
    //     return executor;
    // }

    // @Bean
    // public TaskScheduler taskScheduler(){
    //     ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
    //     taskScheduler.setPoolSize(10);
    //     taskScheduler.setThreadNamePrefix("TaskScheduler thread: ");
    //     return taskScheduler;
    // }
	  
	 
}
