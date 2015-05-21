package helloworld;

public class TestRelection1 {

	/**
	 * 3 ways to get a Class: 1. Object.getClass() 2. .class 3. Class.forName().
	 */
	public void relectClass() {
		String s = "hello";
		Class c1 = s.getClass();
		System.out.println(c1);
		Class c2 = java.lang.String.class;
		System.out.println(c2);
		try {
			Class c3 = Class.forName("java.lang.String");
			System.out.println(c3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Array has its own Class. Notice Array Class's name convention
	 */
	public void relectClass2() {
		String[][] s = new String[][] {};
		Class c1 = s.getClass();
		System.out.println(c1);
		Class c2 = String[][].class;
		System.out.println(c2);
		try {
			Class c3 = Class.forName("[[Ljava.lang.String;");
			System.out.println(c3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Methods that return Classes
	 * 
	 */
	public void relectClass3() {
		Class c = Basket.class;
		/**
		 * Class.getClasses() returns public member classes
		 */
		for (Class ci : c.getClasses()) {
			System.out.println(ci);
		}
		/**
		 * Class.getDeclaredClasses() returns all member classes
		 */
		for (Class ci : c.getDeclaredClasses()) {
			System.out.println(ci);
		}

		Class c1 = new hand() {

			@Override
			public void pick() {
				// TODO Auto-generated method stub

			}

		}.getClass();
		/**
		 * Anonymous class has its Class
		 */
		System.out.println(c1);
		/**
		 * It has no Declaring Class.
		 */
		Class c2 = c1.getDeclaringClass();
		System.out.println(c2);
		/**
		 * But has enclosing Class.
		 */
		Class c3 = c1.getEnclosingClass();
		System.out.println(c3);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRelection1 t = new TestRelection1();
		t.relectClass();
		t.relectClass2();
		t.relectClass3();
	}

}

interface hand {
	public void pick();
}

class Basket {

	public class apple {

	}

	private class banana {

	}
}
