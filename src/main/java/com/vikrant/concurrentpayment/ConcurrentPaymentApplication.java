package com.vikrant.concurrentpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ConcurrentPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentPaymentApplication.class, args);
	}

}
