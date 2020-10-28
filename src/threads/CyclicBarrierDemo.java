package threads;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker1 implements Runnable{
	
	private int id;
	private Random random = new Random();
	private CyclicBarrier cyclicBarrier;
	
	public Worker1(int id,CyclicBarrier cyclicBarrier) {
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		doWork();
	}
	
	private void doWork() {
		System.out.println("Thread with ID : "+id+" starts the task...");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread with ID : "+id+" finished...");
		
		try {
			cyclicBarrier.await();
			System.out.println("after await...");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() { return ""+this.id; }
	
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("All the tasks are finished...");
			}
		});
		
		for(int i=0;i<5;i++)
			executorService.execute(new Worker1(i+1,barrier));
		
		executorService.shutdown();
	}

}
