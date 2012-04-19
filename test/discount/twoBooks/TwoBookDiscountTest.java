package discount.twoBooks;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class TwoBookDiscountTest implements TwoBookDiscountListener {

	private int calls = 0;
	private Price price = null;

	@Override
	public void bestDiscountPriceFound(final Price price) {
		this.price = price;
		calls++;
	}

	@Test
	public void notEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(1));
		new TwoBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(null, price);
		Assert.assertEquals(0, calls);
	}

	@Test
	public void justEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(2));
		new TwoBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 2 * 0.95), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void oneExtraBook() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1));
		new TwoBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 2 * 0.95 + 8), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void twoBooksForDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1), new Book(2));
		new TwoBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 4 * 0.95), price);
		Assert.assertEquals(1, calls);
	}
}
