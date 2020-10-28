package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstPriorityWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public FirstPriorityWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put("B");
			blockingQueue.put("H");
			blockingQueue.put("F");
			Thread.sleep(1000);
			blockingQueue.put("A");
			Thread.sleep(1000);
			blockingQueue.put("E");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}

class SecondPriorityWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public SecondPriorityWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(5000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}

class Person implements Comparable<Person>{

	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Person otherPerson) {
		return name.compareTo(otherPerson.getName());
		// return Integer.compareTo(this.age,otherPerson.getAge()) in case we want to sort by age
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name +" : "+age;
	}
	
}

public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		
		new Thread(new FirstPriorityWorker(queue)).start();
		new Thread(new SecondPriorityWorker(queue)).start();
	}

}
