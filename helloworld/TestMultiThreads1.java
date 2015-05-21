package helloworld;

public class TestMultiThreads1 {

	/**
	 * Seller extends Thread, call Seller.start to run new thread
	 * 
	 */
	private void testSeller(int n) {
		for (int i = 0; i < n; i++) {
			Seller s = new Seller(20);
			s.start();
		}

	}

	/**
	 * Buyer implements Runnable, instantiate new Thread to run it.
	 * 
	 */
	private void testBuyer(int n) {
		for (int i = 0; i < n; i++) {
			Buyer b = new Buyer(20);
			new Thread(b).start();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMultiThreads1 t = new TestMultiThreads1();
		t.testSeller(10);
		t.testBuyer(10);

	}

}

class Seller extends Thread {

	private int ticket;

	public Seller(int ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ticket; i++) {
			System.out.println(getName() + " sells ticket " + i);
		}
	}

}

class Buyer implements Runnable {

	private int ticket;

	public Buyer(int ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ticket; i++) {
			/**
			 * Thread.currentThread() return current running thread.
			 */
			System.out.println(Thread.currentThread().getName()
					+ " buys ticket " + i);
		}
	}

}
