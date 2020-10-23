package threads;

public class DaemonThreads {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = ()->{
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Running");
			}
		};
		
		Thread thread = new Thread(runnable);
		/*JVM statys alive as long as there are any threads running even if main thread terminates.
		 * Marking a thread as daemon thread avoids this and terminates the JVM.
		 * Daemon threads are stopped in an undefined state */
		thread.setDaemon(true); 
		thread.start();
		Thread.sleep(3100);
	}

}
