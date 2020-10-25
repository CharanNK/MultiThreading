package threads;

public class ThreadLocalBasicExample {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(()-> {
			threadLocal.set("Thread1");
			
			try {
				Thread.sleep(2000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			String value = threadLocal.get();
			System.out.println(value);
		});
		
		Thread thread2 = new Thread(()->{
			threadLocal.set("Thread2");
			
			try {
				Thread.sleep(2000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			String value = threadLocal.get();
			System.out.println(value);
		});
		
		thread1.start();
		thread2.start();
	}

}
