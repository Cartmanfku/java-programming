package helloworld;

public class TestMultiThreads2 {

	private void SleepAndInterrupt() throws InterruptedException {
		/**
		 * Instantiate a Thread using anonymous Runnable class.
		 */
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()
								+ " is sleeping " + i);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(Thread.currentThread().getName()
							+ " is interrupted.");
				}
			}

		});
		System.out.println("Start " + t.getName());
		t.start();
		Thread.sleep(5000);
		System.out.println("Interrupt " + t.getName());
		t.interrupt();
	}

	private void SleepAndJoin() throws InterruptedException {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()
								+ " is sleeping " + i);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		System.out.println("Start " + t.getName());
		t.start();
		System.out.println("Joining " + t.getName());
		t.join();
		System.out.println("After  " + t.getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMultiThreads2 t = new TestMultiThreads2();
		try {
			t.SleepAndInterrupt();
		} catch (InterruptedException e) {

		}

		try {
			t.SleepAndJoin();
		} catch (InterruptedException e) {
		}
	}

}
