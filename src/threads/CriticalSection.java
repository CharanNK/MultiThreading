package threads;

public class CriticalSection {
	
	private static int sum1 = 0;
	private static int sum2 = 0;
	
	private static Integer sum1lock = new Integer(1);
	private static Integer sum2lock = new Integer(2);
	
	public static void add(int val1,int val2) {
		synchronized (sum1lock) {
			sum1+=val1;
		}
		synchronized (sum2lock) {
			sum2+=val2;
		}
	}

	public static void main(String[] args) {
		add(6,7);
		System.out.println("sum1 :"+sum1);
		System.out.println("sum2 :"+sum2);
	}

}
