package discount.search;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class BiggestDiscountSearchTest implements BiggestDiscountSearchListener {

	private Price price;

	@Override
	public void bestPriceFound(final Price price) {
		this.price = price;
	}

	@Test
	public void oneBookNoDiscount() {
		final Basket basket = new Basket(new Book(1));
		new BiggestDiscountSearch(basket).findBestPrice(this);
		Assert.assertEquals(new Price(8), price);
	}

}
