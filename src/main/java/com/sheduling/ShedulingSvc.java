package com.sheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

@Service
public class ShedulingSvc {

	/**
	 * This method start every millisecond mentioned in the parameter and it will
	 * use single thread
	 */
	@Scheduled(fixedRate = 500000)
	public void fixedRate() {
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * This method start every millisecond mentioned in the parameter and we added
	 * the @Async this enable the multiple thread
	 */
	@Async
	@Scheduled(fixedRate = 500000)
	public void fixedRateWithAynsc() {
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	@Scheduled(fixedDelay = 50000)
	public void fixedDelay() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	@Schedules({ @Scheduled(fixedRate = 10000000), @Scheduled(cron = "0 * * * * MON-THU") })
	public void checkVehicle() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	@Scheduled(cron = "0 * * * * *")
	public void runEveryMinute() {
		System.out.println("Task executed every minute");
	}
}
