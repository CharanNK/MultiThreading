package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadExecutorDemo {
	
	static class Task implements Runnable{
		private int id;
		
		public Task(int id) {
			this.id = id;
		}
		
		public void run() {
			System.out.println("Task with id "+id+" is in work - thread id: "+Thread.currentThread().getId());
			long duration = (long) (Math.random()*5);
			try {
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<10;i++)
			executor.execute(new Task(i+1));
		
		executor.shutdown();
		
		try {
			if(!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				executor.shutdownNow();
			}
		}catch(InterruptedException ie) {
			executor.shutdownNow();
		}
	}

}
