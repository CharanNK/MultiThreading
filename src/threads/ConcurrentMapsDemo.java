package threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstMapWorker implements Runnable{

	private ConcurrentMap<String, Integer> map;
	
	
	public FirstMapWorker(ConcurrentMap<String, Integer> map) {
		super();
		this.map = map;
	}


	@Override
	public void run() {
		
		try {
			map.put("B", 1);
			map.put("H", 2);
			Thread.sleep(1000);
			map.put("F", 3);
			map.put("A", 4);
			Thread.sleep(1000);
			map.put("E", 5);
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
}

class SecondMapWorker implements Runnable{

	private ConcurrentMap<String, Integer> map;
	
	
	public SecondMapWorker(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}


	@Override
	public void run() {
		
		try {
			System.out.println(map.get("H"));
			Thread.sleep(5000);
			System.out.println(map.get("E"));
			Thread.sleep(1000);
			System.out.println(map.get("B"));
		} catch(Exception ie) {
			ie.printStackTrace();
		}
	}
}

public class ConcurrentMapsDemo {

	public static void main(String[] args) {
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		
		new Thread(new FirstMapWorker(map)).start();
		new Thread(new SecondMapWorker(map)).start();
	}

}
