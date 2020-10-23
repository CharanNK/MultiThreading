package threads;

public class GetThreadName {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("running "+threadName);
		};
		
		Thread thread = new Thread(runnable, "test");
		thread.start();
	}

}
