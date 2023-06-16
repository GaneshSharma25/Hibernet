package pojos;

public enum Course {
	JAVA_BEGINNER(10000), JAVA_EE(20000), PYTHON(15000), REACT(19000);
	private int fees;

	private Course(int fees) {
		this.fees = fees;
	}
	
}
