package basket;

import org.junit.Assert;
import org.junit.Test;

import book.Book;

public class BasketContentsTest implements BasketContentsListener {

	private Basket basket = null;
	private int calls;

	@Override
	public void basketLessUniqueBooks(final Basket basket) {
		this.basket = basket;
		calls++;
	}

	@Test
	public void noUniqueBooks() {
		final Basket basket = new Basket(new Book(1), new Book(1));
		basket.atLeastUniqueBooks(2, this);
		Assert.assertEquals(null, this.basket);
		Assert.assertEquals(0, calls);
	}

	@Test
	public void twoUniqueBooks() {
		final Basket basket = new Basket(new Book(1), new Book(2));
		basket.atLeastUniqueBooks(2, this);
		Assert.assertEquals(0, this.basket.books.size());
		Assert.assertEquals(1, calls);
	}

	@Test
	public void twoUniqueBooksAndSomeNoise() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(5), new Book(4));
		basket.atLeastUniqueBooks(2, this);
		Assert.assertEquals(2, this.basket.books.size());
		Assert.assertEquals(1, calls);
	}

}
