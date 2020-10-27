package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3,true);
	
	public void downloadData() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private void download() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Downloading data from the web..");
	}
}

public class SemaphoreExample {

	public static void main(String[] args) {
		ExecutorService executoService = Executors.newCachedThreadPool();
		
		for(int i=0;i<12;i++){
			executoService.execute(new Runnable() {
				
				@Override
				public void run() {
					Downloader.INSTANCE.downloadData();
				}
			});
		}
	}

}
