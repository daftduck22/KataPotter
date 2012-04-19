package basket;

import org.junit.Assert;
import org.junit.Test;

import book.Book;

public class BasketQuantityTest implements BasketQuantityListener {

	private int quantity;

	@Override
	public void numberOfBooks(final int quantity) {
		this.quantity = quantity;
	}

	@Test
	public void informsBasketListenerOfSizeOne() {
		final Basket basket = new Basket(new Book(1));
		basket.howMany(this);
		Assert.assertEquals(1, quantity);
	}

	@Test
	public void informsBasketListenerOfSizeThree() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1));
		basket.howMany(this);
		Assert.assertEquals(3, quantity);
	}

	@Test
	public void informsBasketListenerOfSizeTen() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1), new Book(3), new Book(4), new Book(6), new Book(8), new Book(22), new Book(10), new Book(11));
		basket.howMany(this);
		Assert.assertEquals(10, quantity);
	}

}
