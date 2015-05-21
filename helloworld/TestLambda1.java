package helloworld;

public class TestLambda1 {

	private int operate(int a, int b, Caculator c) {
		return c.operation(a, b);
	}

	/**
	 * Example using Anonymous Class
	 */
	public void anonymousClass(int a, int b) {
		System.out.println(operate(a, b, new Caculator() {

			@Override
			public int operation(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}

		}));
		System.out.println(operate(a, b, new Caculator() {

			@Override
			public int operation(int a, int b) {
				// TODO Auto-generated method stub
				return a - b;
			}

		}));
	}

	public void lambda(int a, int b) {
		/**
		 * Lambda expression is supported after jre1.8.
		 */
		System.out.println(operate(a, b, (x, y) -> x + y));
		System.out.println(operate(a, b, (x, y) -> x - y));
		/**
		 * Brackets if it's not a simple one line expression.
		 */
		System.out.println(operate(a, b, (x,y)-> {
			int temp = x*x;
			return temp + y;
		}));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLambda1 t = new TestLambda1();
		t.anonymousClass(10, 7);
		t.lambda(11, 6);
	}

}

/**
 * A functional interface is any interface 
 * that contains only one abstract method.
 *
 */
interface Caculator {
	int operation(int a, int b);
}
