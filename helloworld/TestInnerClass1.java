package helloworld;

import helloworld.OutterClass.InnerClass;

public class TestInnerClass1 {

	public static void main(String[] args) {
		/**
		 * create an outter class
		 */
		OutterClass outer = new OutterClass(false);
		outer.printCoin();

		/**
		 * create InnerClass inside of OutterClass
		 */
		outer.flipCoinFromOutter();
		outer.printCoin();

		/**
		 * create InnerClass using outer. notice we have to import InnerClass on
		 * this step
		 */
		InnerClass inner = outer.new InnerClass();

		/**
		 * flipCoin using inner
		 */
		inner.flipCoin1();
		outer.printCoin();

		inner.flipCoin2();
		outer.printCoin();

	}

}

class OutterClass {
	private boolean coin;

	OutterClass(boolean coin) {
		this.coin = coin;
	}

	/**
	 * create an InnerClass to flip coin
	 */
	public void flipCoinFromOutter() {
		InnerClass inner = new InnerClass();
		inner.flipCoin1();
	}

	public void printCoin() {
		System.out.println("Coin is " + coin);
	}

	public class InnerClass {

		/**
		 * coin == OutterClass.this.coin
		 */
		public void flipCoin1() {
			coin = !coin;
		}

		public void flipCoin2() {
			OutterClass.this.coin = !OutterClass.this.coin;
		}
	}
}
