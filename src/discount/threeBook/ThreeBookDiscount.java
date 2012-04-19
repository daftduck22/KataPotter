package discount.threeBook;

import price.Price;
import basket.Basket;
import basket.BasketContentsListener;
import discount.search.BiggestDiscountSearch;
import discount.search.BiggestDiscountSearchListener;

public class ThreeBookDiscount implements BasketContentsListener, BiggestDiscountSearchListener {

	private Price bestPriceForRemainingBasket = null;

	public ThreeBookDiscount(final Basket basket) {
		basket.atLeastUniqueBooks(3, this);
	}

	@Override
	public void basketLessUniqueBooks(final Basket basket) {
		new BiggestDiscountSearch(basket).findBestPrice(this);
	}

	@Override
	public void bestPriceFound(final Price price) {
		bestPriceForRemainingBasket = price;
	}

	public void findBestPrice(final ThreeBookDiscountListener listener) {
		if (bestPriceForRemainingBasket != null) {
			listener.bestDiscountPriceFound(bestPriceForRemainingBasket.add(new Price(0.9 * 8 * 3)));
		}
	}

}
