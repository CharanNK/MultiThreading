package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public FirstWorker(BlockingQueue<Integer> blockingQueue2) {
		this.blockingQueue = blockingQueue2;
	}

	@Override
	public void run() {
		int counter = 0;

		while (true) {
			try {
				blockingQueue.put(counter);
				System.out.println("Putting items into the queue.." + counter);
				counter++;
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public SecondWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Taking items from the queue.." + number);
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}

public class BlockingQueueDemo {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
		
		FirstWorker firstWorker = new FirstWorker(blockingQueue);
		SecondWorker secondWorker = new SecondWorker(blockingQueue);
		
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
	}

}
