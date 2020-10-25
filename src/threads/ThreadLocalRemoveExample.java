package threads;

public class ThreadLocalRemoveExample {

	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		Thread thread1 = new Thread(()-> {
			threadLocal.set("Thread1"); //sets a value to thread local
			
			String value = threadLocal.get(); //gets value from thread local
			System.out.println(value);
			
			threadLocal.remove(); //remove the value from the thread local * thread local can store only 1 value
			value = threadLocal.get();
			System.out.println(value);
		});
		
		Thread thread2 = new Thread(()->{
			threadLocal.set("Thread2"); //sets a value to thread local
			
			String value = threadLocal.get(); //gets value from thread local
			System.out.println(value);
			
			try {
				Thread.sleep(3000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			threadLocal.remove(); //remove the value from the thread local * thread local can store only 1 value
			value = threadLocal.get();
			System.out.println(value);
		});
		
		thread1.start();
		thread2.start();
	}

}
