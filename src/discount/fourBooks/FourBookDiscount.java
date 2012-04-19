package discount.fourBooks;

import price.Price;
import basket.Basket;
import basket.BasketContentsListener;
import discount.search.BiggestDiscountSearch;
import discount.search.BiggestDiscountSearchListener;

public class FourBookDiscount implements BasketContentsListener, BiggestDiscountSearchListener {

	private Price bestPriceForRemainingBasket = null;

	public FourBookDiscount(final Basket basket) {
		basket.atLeastUniqueBooks(4, this);
	}

	@Override
	public void basketLessUniqueBooks(final Basket basket) {
		new BiggestDiscountSearch(basket).findBestPrice(this);
	}

	@Override
	public void bestPriceFound(final Price price) {
		bestPriceForRemainingBasket = price;
	}

	public void findBestPrice(final FourBookDiscountListener listener) {
		if (bestPriceForRemainingBasket != null) {
			listener.bestDiscountPriceFound(bestPriceForRemainingBasket.add(new Price(0.8 * 8 * 4)));
		}
	}

}
