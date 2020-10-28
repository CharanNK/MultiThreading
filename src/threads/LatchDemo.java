package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable{
	
	private int id;
	private CountDownLatch countDownLatch;
	
	public Worker(int id, CountDownLatch countDownLatch) {
		this.id = id;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		doWork();
		countDownLatch.countDown();
	}

	private void doWork() {
		System.out.println("Thread with id "+this.id+" starts working...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
public class LatchDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i=0;i<5;i++)
			executor.execute(new Worker(i, latch));
		
		try {
			latch.await(); //it is important to call await
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All thread visits are done..");
		
		executor.shutdown();
	}

}
