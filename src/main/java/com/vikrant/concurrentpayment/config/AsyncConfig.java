package com.vikrant.concurrentpayment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    @Bean(name = "paymentExecutor")
    public Executor paymentExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);           // 3 threads active always
        executor.setMaxPoolSize(5);            // Max 5 threads
        executor.setQueueCapacity(10);         // Queue 10 tasks
        executor.setThreadNamePrefix("PaymentThread-");
        executor.initialize();
        return executor;
    }
}
