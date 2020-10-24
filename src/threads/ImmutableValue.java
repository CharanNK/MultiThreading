package threads;

public class ImmutableValue {
	
	class ImmutableValueClass{
		private int value = 0;
		
		public ImmutableValueClass(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public ImmutableValueClass add(int valueToAdd) {
			return new ImmutableValueClass(this.value+valueToAdd);
		}
	}

	public static void main(String[] args) {

	}

}
