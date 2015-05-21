package helloworld;

public class TestMultiThread3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Ticket {
	
	private int t;

	public Ticket(int t) {
		super();
		this.t = t;
	}

	public synchronized void buy() {
		t += 1;
	}

	public synchronized void sell() {
		t -= 1;
	}
	
	public int get() {
		return t;
	}
	
}

class Bank {
	
}