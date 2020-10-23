package threads;

public class ThreadJoin {

	public static void main(String[] args) {
		Runnable runnable = ()->{
			for(int i=0;i<5;i++) {
				sleep(1000);
				System.out.println("Running");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		try {
			thread.join(); // tells the main thread to wait till this thread is completed
		}catch (InterruptedException e) {
		}
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
