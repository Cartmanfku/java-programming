package helloworld;

public class TestInnerClass3 {
	
	private String username;
	
	public TestInnerClass3(String username) {
		this.username = username;
	}

	public void printUserName(final String name) {
		/**
		 * name must be final so that Printer can access it
		 */
		Printer p = new Printer (){

			@Override
			public void printName() {
				// TODO Auto-generated method stub
				System.out.println(name);
				System.out.println(username);
				
			}
			
		};	
		
		p.printName();
	}
	
	public void printUserName(Printer p){
		p.printName();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInnerClass3 t1 = new TestInnerClass3("cartman");
		t1.printUserName(t1.username);
		
		/**
		 * Instantiate anonymous class as a parameter.
		 */
		final TestInnerClass3 t2 = new TestInnerClass3("cartman2");
		t2.printUserName(new Printer(){

			@Override
			public void printName() {
				// TODO Auto-generated method stub
				System.out.println(t2.username);
			}
			
		});

	}

}

interface Printer {
	public void printName();
}
