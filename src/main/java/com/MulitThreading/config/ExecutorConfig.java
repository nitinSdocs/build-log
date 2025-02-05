package com.MulitThreading.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.SimpleAsyncTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ExecutorConfig {
	/*---------It is must to have bean named as <taskExecutor> to be picked up by spring------------*/

    /* “By default, Spring will be searching for an associated thread pool definition:
        either a unique TaskExecutor bean in the context, or an Executor bean named "taskExecutor" otherwise.
        If neither of the two is resolvable, a SimpleAsyncTaskExecutor will be used to process async method invocations.”
     */

	  @Bean 
      public Executor taskExecutor() { 
	    ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
	    executor.setThreadNamePrefix("Executor thread: "); 
        return executor;
	  }

    // @Bean
    // public Executor customThreadPoolExecutor() {
    //     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    //     executor.setCorePoolSize(2);
    //     executor.setThreadNamePrefix("Executor thread: ");
    //     return executor;
    // }

    // @Bean("ExecutorForScheduled")
    // public Executor threadPoolTaskExecutor() {
    //     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    //     executor.setCorePoolSize(16);
    //     executor.setThreadNamePrefix("ExecutorForScheduled: ");
    //     executor.initialize();
    //     return executor;
    // }

    // @Bean
    // public TaskScheduler taskScheduler(){
    //     ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
    //     // SimpleAsyncTaskScheduler taskScheduler= new SimpleAsyncTaskScheduler();
    //     taskScheduler.setPoolSize(2);
    //     taskScheduler.setThreadNamePrefix("TaskScheduler thread: ");
    //     return taskScheduler;
    // }
	  
	 
}
