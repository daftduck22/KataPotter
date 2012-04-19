package calculator;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class SingleDiscountCalculatorTest implements CalculatorListener {

	private Price price;

	@Override
	public void totalPrice(final Price price) {
		this.price = price;
	}

	@Test
	public void twoBooksDiscountFivePerCent() {
		final Basket basket = new Basket(new Book(1), new Book(2));
		final Calculator calc = new Calculator(basket);
		calc.calculatePrice(this);
		Assert.assertEquals(new Price(2 * 8 * 0.95), price);
	}

	@Test
	public void threeBooksDiscountTenPerCent() {
		final Basket basket = new Basket(new Book(1), new Book(3), new Book(5));
		final Calculator calc = new Calculator(basket);
		calc.calculatePrice(this);
		Assert.assertEquals(new Price(3 * 8 * 0.9), price);
	}

	@Test
	public void fourBooksDiscountTwentyPerCent() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3), new Book(5));
		final Calculator calc = new Calculator(basket);
		calc.calculatePrice(this);
		Assert.assertEquals(new Price(4 * 8 * 0.8), price);
	}

	@Test
	public void fiveBooksDiscountTwentyFivePerCent() {
		final Basket basket = new Basket(new Book(1), new Book(2), new Book(3), new Book(4), new Book(5));
		final Calculator calc = new Calculator(basket);
		calc.calculatePrice(this);
		Assert.assertEquals(new Price(5 * 8 * 0.75), price);
	}
}
