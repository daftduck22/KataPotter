package discount.fiveBooks;

import price.Price;
import basket.Basket;
import basket.BasketContentsListener;
import discount.search.BiggestDiscountSearch;
import discount.search.BiggestDiscountSearchListener;

public class FiveBookDiscount implements BasketContentsListener, BiggestDiscountSearchListener {

	private Price bestPriceForRemainingBasket = null;

	public FiveBookDiscount(final Basket basket) {
		basket.atLeastUniqueBooks(5, this);
	}

	@Override
	public void basketLessUniqueBooks(final Basket basket) {
		new BiggestDiscountSearch(basket).findBestPrice(this);
	}

	@Override
	public void bestPriceFound(final Price price) {
		bestPriceForRemainingBasket = price;
	}

	public void findBestPrice(final FiveBookDiscountListener listener) {
		if (bestPriceForRemainingBasket != null) {
			listener.bestDiscountPriceFound(bestPriceForRemainingBasket.add(new Price(0.75 * 8 * 5)));
		}
	}

}
