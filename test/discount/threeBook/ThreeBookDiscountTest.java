package discount.threeBook;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class ThreeBookDiscountTest implements ThreeBookDiscountListener {

	private int calls = 0;
	private Price price = null;

	@Override
	public void bestDiscountPriceFound(final Price price) {
		this.price = price;
		calls++;
	}

	@Test
	public void notEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(1));
		new ThreeBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(null, price);
		Assert.assertEquals(0, calls);
	}

	@Test
	public void justEnoughBooks() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3));
		new ThreeBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 3 * 0.9), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void oneExtraBook() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(1), new Book(3));
		new ThreeBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 3 * 0.9 + 8), price);
		Assert.assertEquals(1, calls);
	}

	@Test
	public void ThreeBooksForDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3), new Book(1), new Book(2), new Book(3));
		new ThreeBookDiscount(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8 * 6 * 0.9), price);
		Assert.assertEquals(1, calls);
	}
}
