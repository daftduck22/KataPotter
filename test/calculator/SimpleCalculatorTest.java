package calculator;

import org.junit.Assert;
import org.junit.Test;

import price.Price;
import basket.Basket;
import book.Book;

public class SimpleCalculatorTest implements CalculatorListener {

	private Price price;

	@Override
	public void totalPrice(final Price price) {
		this.price = price;
	}

	@Test
	public void noBooksCostNothing() {
		final Basket basket = new Basket();
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(0), price);
	}

	@Test
	public void testCostOfFirstBook() {
		final Basket basket = new Basket(new Book(1));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8), price);
	}

	@Test
	public void testCostOfSecondBook() {
		final Basket basket = new Basket(new Book(2));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8), price);
	}

	@Test
	public void testCostOfThirdBook() {
		final Basket basket = new Basket(new Book(3));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8), price);
	}

	@Test
	public void testCostOfFourthBook() {
		final Basket basket = new Basket(new Book(4));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8), price);
	}

	@Test
	public void testCostOfFifthBook() {
		final Basket basket = new Basket(new Book(5));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(8), price);
	}

	@Test
	public void testCostOfTwoFirstBooks() {
		final Basket basket = new Basket(new Book(1), new Book(1));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(2 * 8), price);
	}

	@Test
	public void testCostOfThreeSecondBooks() {
		final Basket basket = new Basket(new Book(2), new Book(2), new Book(2));
		new Calculator(basket).calculatePrice(this);
		Assert.assertEquals(new Price(3 * 8), price);
	}

}
