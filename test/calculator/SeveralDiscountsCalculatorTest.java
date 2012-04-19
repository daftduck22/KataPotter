package calculator;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class SeveralDiscountsCalculatorTest implements CalculatorListener {

	private Price price;

	@Override
	public void totalPrice(final Price price) {
		this.price = price;
	}

	@Test
	public void twoBookDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(2));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8 + 8 * 2 * 0.95), price);
	}

	@Test
	public void twoTwoBookDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(2), new Book(2));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(2 * 8 * 2 * 0.95), price);
	}

	@Test
	public void twoBookAndFourBookDiscount() {
		final Basket basket = new Basket(new Book(1), new Book(1), new Book(2), new Book(3), new Book(3), new Book(4));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8 * 4 * 0.8 + 8 * 2 * 0.95), price);
	}

	@Test
	public void fiveBookDiscountPlusOneBook() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(2), new Book(3), new Book(4), new Book(5));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8 + 8 * 5 * 0.75), price);
	}

}
