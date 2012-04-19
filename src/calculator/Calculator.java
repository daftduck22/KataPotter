package calculator;

import price.Price;
import basket.Basket;
import discount.search.BiggestDiscountSearch;
import discount.search.BiggestDiscountSearchListener;

public class Calculator implements BiggestDiscountSearchListener {

	private final BiggestDiscountSearch search;
	private CalculatorListener listener;

	public Calculator(final Basket basket) {
		search = new BiggestDiscountSearch(basket);
	}

	@Override
	public void bestPriceFound(final Price price) {
		listener.totalPrice(price);
	}

	public void calculatePrice(final CalculatorListener listener) {
		this.listener = listener;
		search.findBestPrice(this);
	}
}
