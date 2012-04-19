package discount.search;

import price.Price;
import basket.Basket;
import basket.BasketQuantityListener;
import discount.fiveBooks.FiveBookDiscount;
import discount.fiveBooks.FiveBookDiscountListener;
import discount.fourBooks.FourBookDiscount;
import discount.fourBooks.FourBookDiscountListener;
import discount.threeBook.ThreeBookDiscount;
import discount.threeBook.ThreeBookDiscountListener;
import discount.twoBooks.TwoBookDiscount;
import discount.twoBooks.TwoBookDiscountListener;

public class BiggestDiscountSearch implements BasketQuantityListener, TwoBookDiscountListener, ThreeBookDiscountListener, FourBookDiscountListener, FiveBookDiscountListener {

	private Price bestPrice = null;

	public BiggestDiscountSearch(final Basket basket) {
		basket.howMany(this);
		new TwoBookDiscount(basket).findBestPrice(this);
		new ThreeBookDiscount(basket).findBestPrice(this);
		new FourBookDiscount(basket).findBestPrice(this);
		new FiveBookDiscount(basket).findBestPrice(this);
	}

	@Override
	public void numberOfBooks(final int quantity) {
		bestPrice = new Price(8 * quantity);
	}

	@Override
	public void bestDiscountPriceFound(final Price price) {
		bestPrice = price.lowestPrice(bestPrice);
	}

	public void findBestPrice(final BiggestDiscountSearchListener listener) {
		listener.bestPriceFound(bestPrice);
	}

}
