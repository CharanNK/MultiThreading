package threads;

class Runner1 implements Runnable{
//	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(10);
				System.out.println("Runner 1 : "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Runner2 implements Runnable{
//	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(20);
				System.out.println("Runner 2 : "+i);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

public class Basics {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner1());
		Thread thread2 = new Thread(new Runner2());
		
		thread1.start();
		thread2.start();
	}

}
