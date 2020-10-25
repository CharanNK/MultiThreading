package threads;

public class InheritableThreadLocalExample {

	public static void main(String[] args) {
		
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
		
		Thread thread1 = new Thread(()->{
			System.out.println("====== Thread 1 =====");
			threadLocal.set("Thread1 - threadlocal");
			inheritableThreadLocal.set("Thread1 - inheritable thread local");
			
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
			
			Thread childThread = new Thread(()->{
				System.out.println("===== Child thread =====");
				System.out.println(threadLocal.get());
				System.out.println(inheritableThreadLocal.get());
			});
			
			childThread.start();
		});
		
		thread1.start();
		
		Thread thread2 = new Thread(()->{
			
			try {
				Thread.sleep(3000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
			System.out.println("===== Thread 2 =====");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});
		
		thread2.start();
 	}

}
