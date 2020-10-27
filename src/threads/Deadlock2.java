package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock2 {
	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);
	
	public static void main(String[] args) {
		
		Deadlock2 deadlock = new Deadlock2();
		
		new Thread(deadlock::worker1,"worker1").start();
		new Thread(deadlock::worker2,"worker2").start();
	}
	
	public void worker1() {
		lock1.lock();
		System.out.println("worker1 acquires the lock1..");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock2.lock();
		System.out.println("Worker1 acquired the lock2...");
		lock1.unlock();
		lock2.unlock();
	}
	
	public void worker2() {
		lock2.lock();
		System.out.println("worker2 acquires the lock2..");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock1.lock();
		System.out.println("Worker2 acquired the lock1...");
		lock1.unlock();
		lock2.unlock();
	}
}
