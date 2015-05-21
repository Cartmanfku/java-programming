package helloworld;

public class TestInnerClass2 {
	
	/**
	 * caller must be final so that local class can access it
	 */
	public void printPhoneNumber(String phoneNumber, final String caller) {
		class Phone {
			private String phoneNumber;
			
			Phone(String phoneNumber) {
				this.phoneNumber= phoneNumber;
			}
			
			public void printNumber() {
				System.out.println(caller + " calling " + phoneNumber);
			}
			
			
		};
		
		Phone p = new Phone(phoneNumber);
		p.printNumber();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInnerClass2 t = new TestInnerClass2();
		t.printPhoneNumber("123-4567-890", "cartman");
	}

}
