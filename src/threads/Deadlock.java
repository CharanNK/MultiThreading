package threads;

public class Deadlock {

	public static void main(String[] args) {
		final String resource1 = new String("Charan");
		final String resource2 = new String("Divya");
		
		Thread thread1 = new Thread(()->{
			synchronized (resource1) {
				System.out.println("Thread 1 : locked resource 1");
				
				try { Thread.sleep(1000);} catch (Exception e) {}
				
				synchronized (resource2) {
					System.out.println("Thread 1 : locked resource 2");
				}
			}
		});
		
		Thread thread2 = new Thread(()->{
			synchronized (resource2) {
				System.out.println("Thread 2 : locked resource2");
				try { Thread.sleep(1000);} catch (Exception e) {}
				synchronized (resource1) {
					System.out.println("Thread 2 : locked resouce 1");
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}

}
