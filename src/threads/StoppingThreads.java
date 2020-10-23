package threads;


public class StoppingThreads {
	
	public static class RunnableStoppable implements Runnable{

		private boolean stopRequested = false;
		
		public synchronized void requestStop() {
			stopRequested = true;
		}
		
		public synchronized boolean isStopRequested() {
			return stopRequested;
		}
		
		private void sleep(long millis) {
			try {
				Thread.sleep(millis);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			System.out.println("Thread running");
			while( !isStopRequested() ) {
				sleep(1000);
				System.out.println(". .");
			}
			System.out.println("Thread stopped");
		}
		
	}

	public static void main(String[] args) {
		RunnableStoppable runnableStoppable = new RunnableStoppable();
		Thread thread = new Thread(runnableStoppable, "Thread1");
		thread.start();
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Requesting stop");
		runnableStoppable.requestStop();
		System.out.println("Request stopped");
	}

}
