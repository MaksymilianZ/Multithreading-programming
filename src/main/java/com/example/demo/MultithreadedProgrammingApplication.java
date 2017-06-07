package com.example.demo;

import com.example.demo.threads.DownloadDataRunnable;
import com.example.demo.threads.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MultithreadedProgrammingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MultithreadedProgrammingApplication.class, args);

		DownloadDataRunnable downloadDataRunnable = context.getBean(DownloadDataRunnable.class);
		Consumer consumer1 = context.getBean(Consumer.class,downloadDataRunnable);
		Consumer consumer2 = context.getBean(Consumer.class,downloadDataRunnable);
		Consumer consumer3 = context.getBean(Consumer.class,downloadDataRunnable);

		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
		threadPool.scheduleAtFixedRate(downloadDataRunnable,0,1, TimeUnit.SECONDS);
		threadPool.scheduleWithFixedDelay(consumer1,1,10,TimeUnit.SECONDS);
		threadPool.scheduleWithFixedDelay(consumer2,1,10,TimeUnit.SECONDS);
		threadPool.scheduleWithFixedDelay(consumer3,1,10,TimeUnit.SECONDS);
	}
}
