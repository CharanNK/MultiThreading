package threads;

public class ThreadExample {
	
	//create a subclass of the Thread class and override the run method
	public static class MyThread extends Thread{
		public void run() {
			System.out.println("MyThread running");
			System.out.println("MyThread finished");
		}
	}
	
	//create a class that implements the runnable interface with own definition for run method
	public static class RunnableThread implements Runnable{
		@Override
		public void run() {
			System.out.println("RunnableThread running");
			System.out.println("RunnableThread finished");
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		
		Thread thread = new Thread( new RunnableThread());
		thread.start();
		
		/* Anonymous implementation of Runnable*/
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anonymous runnable running");
				System.out.println("anonymous runnable finished");
			}
		};
		
		Thread thread2 = new Thread(runnable);
		thread2.start();
		
		/*Java lambda implementation of runnable*/
		Runnable lambdaRunnable = ()->{
			System.out.println("Lambda running");
			System.out.println("Lambda finished");
		};
		
		Thread lambdaThread = new Thread(lambdaRunnable);
		lambdaThread.start();
	}

}
