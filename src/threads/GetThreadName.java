package threads;

public class GetThreadName {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("running "+threadName);
			
			try {
				Thread.sleep(2000);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			System.out.println(threadName+" finished");
		};
		
		Thread thread = new Thread(runnable, "test");
		thread.start();
		
		Thread thread2 = new Thread(runnable,"thread2 ");
		thread2.start();
	}

}
