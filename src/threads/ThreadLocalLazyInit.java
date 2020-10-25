package threads;

public class ThreadLocalLazyInit {

	public static void main(String[] args) {

		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		
		String value = threadLocal.get();
		if(null==value) {
			threadLocal.set("Lazily set value");
			value = threadLocal.get();
		}
		
		System.out.println(value);
	}

}
