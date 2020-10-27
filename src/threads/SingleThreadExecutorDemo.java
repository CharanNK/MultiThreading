package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutorDemo {
	
	static class Task implements Runnable{
		private int id;
		
		public Task(int id) {
			this.id = id;
		}
		
		public void run() {
			System.out.println("Task with id "+id+" is in work - thread id: "+Thread.currentThread().getName());
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
		//it is a single thread tat will execute the tasks sequentially
		//one after another
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for(int i=0;i<5;i++) {
			executorService.execute(new Task(i));
		}
		
		executorService.shutdown();
	}
}
