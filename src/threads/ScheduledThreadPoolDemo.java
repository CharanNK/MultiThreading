package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
	
	static class StockMarketUpdater implements Runnable{
		public void run() {
			System.out.println("Updating and downloading stock related data from web..");
		}
	}
 
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		executor.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);
		//executor.scheduleAtFixedRate(command, initialDelay, period, unit);
		
	}

}
