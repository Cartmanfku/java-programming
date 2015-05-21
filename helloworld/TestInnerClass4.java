package helloworld;

public class TestInnerClass4 {
	
	public static String outer = "Outer";
	
	public static class InnerClass {
		/**
		 * Static nested class can have static member.
		 */
		private static String inner = "Inner";
		
		public void printInner() {
			System.out.println(outer);
			System.out.println(inner);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Static nested class does not reply on outer class object.
		 */
		InnerClass inner = new TestInnerClass4.InnerClass();
		inner.printInner();
	}

}
