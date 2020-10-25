package threads;

public class Exchanger {
	private Object 			 object = null;
	private volatile boolean hasNewObject = false;
	
	public void setObject(Object object) {
		this.object = new Object();
		this.hasNewObject = true;
	}
	
	public Object getObject() {
		
		while(!hasNewObject) {
			
		}
		
		this.hasNewObject= false;
		return this.object;
	}
}
