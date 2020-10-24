package threads;

public class ImmutableValue {
	
	class ImmutableValueClass{
		private int value = 0;
		
		public ImmutableValueClass(int value) {
			this.value = value;		//once an immutable value instance is created you cannot change it's value.
				//It is immutable
		}
		
		public int getValue() {
			return this.value;
		}
		
		public ImmutableValueClass add(int valueToAdd) {
			return new ImmutableValueClass(this.value+valueToAdd);
		}
	}
	
	class Calculator{
		private ImmutableValueClass currentValue = null;
		
		public ImmutableValueClass getValue() {
			return currentValue;
		}
		
		public void setValue(ImmutableValueClass value) {
			this.currentValue = value;
		}
		
		public void addValue(int valueToAdd) {
			this.currentValue = this.currentValue.add(valueToAdd);
		}
	}

	public static void main(String[] args) {

	}

}
