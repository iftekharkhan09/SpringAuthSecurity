package com.myproject.throttle.ThrottlerApp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SimpleRateInterceptor {
	private Semaphore semaphore;
	private int maxLimit;
	private TimeUnit timeUnit;
	private ScheduledExecutorService scheduler;

	public SimpleRateInterceptor(int maxLimit, TimeUnit timeUnit) {
		this.maxLimit = maxLimit;
		this.timeUnit = timeUnit;
		this.semaphore = new Semaphore(maxLimit);
	}

	public boolean acquire() {
		return semaphore.tryAcquire();
	}

	public static SimpleRateInterceptor create(int maxLimit, TimeUnit timeUnit) {
		SimpleRateInterceptor limiter = new SimpleRateInterceptor(maxLimit, timeUnit);
		limiter.replenish(timeUnit);
		return limiter;
	}

	public void replenish(TimeUnit timeUnit) {
		scheduler = Executors.newScheduledThreadPool(1);
		scheduler.schedule(() -> {
			semaphore.release(maxLimit - semaphore.availablePermits());
		}, 1, timeUnit);
	}
}
