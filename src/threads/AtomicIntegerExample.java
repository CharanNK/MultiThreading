package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	
	private static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(()->{
			increment();
		});
		
		Thread t2 = new Thread(()->{
			increment();
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Counter value : "+counter);
	}
	
	public static void increment() {
		for(int i=0;i<10000;i++)
			counter.getAndIncrement();
	}
}
