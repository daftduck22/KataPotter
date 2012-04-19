package calculator;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class EdgeCaseDiscountCalculatorTest implements CalculatorListener {

	private Price price;

	@Override
	public void totalPrice(final Price price) {
		this.price = price;
	}

	@Test
	public void twoBookDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(2), new Book(2), new Book(3), new Book(3), new Book(4), new Book(5));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(2 * 8 * 4 * 0.8), price);
	}

	@Test
	public void fiveBookDiscountAndTwoFourBookDiscounts() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(1), new Book(1), new Book(1), new Book(2), new Book(2), new Book(2), new Book(2), new Book(2), new Book(3), new Book(3), new Book(3), new Book(3), new Book(4),
				new Book(4), new Book(4), new Book(4), new Book(4), new Book(5), new Book(5), new Book(5), new Book(5));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(3 * 8 * 5 * 0.75 + 2 * 8 * 4 * 0.8), price);
	}
}
