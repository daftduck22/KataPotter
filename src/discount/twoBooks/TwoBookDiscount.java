package discount.twoBooks;

import price.Price;
import basket.Basket;
import basket.BasketContentsListener;
import discount.search.BiggestDiscountSearch;
import discount.search.BiggestDiscountSearchListener;

public class TwoBookDiscount implements BasketContentsListener, BiggestDiscountSearchListener {

	private Price bestPriceForRemainingBasket = null;

	public TwoBookDiscount(final Basket basket) {
		basket.atLeastUniqueBooks(2, this);
	}

	@Override
	public void basketLessUniqueBooks(final Basket basket) {
		new BiggestDiscountSearch(basket).findBestPrice(this);
	}

	@Override
	public void bestPriceFound(final Price price) {
		bestPriceForRemainingBasket = price;
	}

	public void findBestPrice(final TwoBookDiscountListener listener) {
		if (bestPriceForRemainingBasket != null) {
			listener.bestDiscountPriceFound(bestPriceForRemainingBasket.add(new Price(0.95 * 8 * 2)));
		}
	}

}
