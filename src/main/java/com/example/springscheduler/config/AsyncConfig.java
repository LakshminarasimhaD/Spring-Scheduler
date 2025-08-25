package com.example.springscheduler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	@Bean(name = "customTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Minimum threads
        executor.setMaxPoolSize(10); // Maximum threads
        executor.setQueueCapacity(20); // Queue for pending tasks
        executor.setThreadNamePrefix("My-Async-");
        executor.initialize();
        return executor;
    }

}
