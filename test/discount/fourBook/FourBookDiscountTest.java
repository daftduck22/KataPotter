package discount.fourBook;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;
import discount.fourBooks.FourBookDiscount;
import discount.fourBooks.FourBookDiscountListener;

public class FourBookDiscountTest implements FourBookDiscountListener {

	private int calls = 0;
	private Price price = null;

	@Override
	public void bestDiscountPriceFound(final Price price) {
		this.price = price;
		calls++;
	}

	@Test
	public void notEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(1), new Book(1));
		new FourBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(null, price);
		Assert.assertEquals(0, calls);
	}

	@Test
	public void justEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3), new Book(4));
		new FourBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 4 * 0.8), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void oneExtraBook() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1), new Book(3), new Book(4));
		new FourBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 4 * 0.8 + 8), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void FourBooksForDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3), new Book(4), new Book(1), new Book(2), new Book(3), new Book(4));
		new FourBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 8 * 0.8), price);
		Assert.assertEquals(1, calls);
	}
}
