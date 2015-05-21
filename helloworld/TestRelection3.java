package helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRelection3 {

	public void testField(Book b) throws Exception {
		Class<? extends Book> c = b.getClass();

		for (Field f : c.getDeclaredFields()) {
			System.out.println(f.getName() + ":" + f.getModifiers());
		}

		Field chap = c.getDeclaredField("chapters");
		chap.setLong(b, 12);

		Field chars = c.getDeclaredField("characters");
		chars.set(b, new String[] { "new Alice", "new White" });

		System.out.println(b.chapters);
		for (String s : b.characters) {
			System.out.println(s);
		}

		Field bn = c.getDeclaredField("bn");
		bn.setAccessible(true);
		bn.setBoolean(b, true);
		System.out.println(b.isBn());

	}

	public void testMethod(Book b) throws Exception {
		Class<? extends Book> c = b.getClass();

		for (Method m : c.getDeclaredMethods()) {
			System.out.println(m.getName() + ":" + m.getReturnType());
			for (Class<?> t : m.getParameterTypes()) {
				System.out.println(t.getName());
			}
		}

		Method set = c
				.getDeclaredMethod("setBn", new Class[] { boolean.class });
		set.invoke(b, new Object[] { false });
		Method get = c.getDeclaredMethod("isBn");
		System.out.println(get.invoke(b));

		Method hello = c.getDeclaredMethod("hello",
				new Class[] { String.class });
		hello.setAccessible(true);
		hello.invoke(b, new Object[] { new String("world") });

	}

	public void testConstructor(Book b) throws Exception {
		Class<? extends Book> c = b.getClass();

		for (Constructor<?> s : c.getDeclaredConstructors()) {
			System.out.println(s.getName());
			for (Class<?> t : s.getParameterTypes()) {
				System.out.println(t.getName());
			}
		}

		Constructor<? extends Book> s1 = c.getConstructor();
		Book b1 = (Book) s1.newInstance();
		System.out.println(b1 + ":" + b1.chapters);

		Constructor<? extends Book> s2 = c.getConstructor(new Class[] {
				long.class, String[].class, boolean.class });
		Book b2 = (Book) s2.newInstance(new Object[] { 12,
				new String[] { "a", "b" }, true });
		System.out.println(b2 + ":" + b2.chapters);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRelection3 t = new TestRelection3();
		try {
			Book b = new Book();
			t.testField(b);
			t.testMethod(b);
			t.testConstructor(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Book {
	public long chapters = 0;
	public String[] characters = { "Alice", "White" };
	private boolean bn = false;

	public Book() {
		System.out.println("public constructor");
	}

	public Book(long chapters, String[] characters, boolean bn) {
		this();
		this.chapters = chapters;
		this.characters = characters;
		this.bn = bn;
	}

	public boolean isBn() {
		return bn;
	}

	public void setBn(boolean bn) {
		this.bn = bn;
	}

	private void hello(String name) {
		System.out.println("hello " + name);
	}

}
