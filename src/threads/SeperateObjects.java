package threads;

public class SeperateObjects {
	
	static class MyObject{
		
	}
	
	static class MyRunnable implements Runnable{
		
		public int count = 0;
		public MyObject myObject = null;
		
		
		@Override
		public void run() {
			
			MyObject myObject = new MyObject();  //local variable myObject will be in thread stack of each thread.
									//but they will internally point to one object of MyObject in the heap memory.
			System.out.println(Thread.currentThread().getName()+":"+myObject);
			
			
			for(int i=0;i<10000;i++) {
				synchronized (this) {
					count++;
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+this.count );
		}
	}

	public static void main(String[] args) {
		
		int myLocalVar = 0;  // stored on thread stack - in this case main thread
		String myLocalString = "Text";  //stored on thread stack
		
		Runnable runnable1 = new MyRunnable(); //Stored on the heap
		Runnable runnable2 = new MyRunnable();	//Stored on the heap
		
		Thread thread1 = new Thread(runnable1,"Thread 1");
		Thread thread2 = new Thread(runnable2,"Thread 2");
		
		thread1.start();
		thread2.start();
		
		
		Runnable sharedRunnable = new MyRunnable();
		
		Thread thread3 = new Thread(sharedRunnable,"Thread 3");
		Thread thread4 = new Thread(sharedRunnable,"Thread 4");
		
		thread3.start();
		thread4.start();
	}

}
