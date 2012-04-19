package price;

public class Price {

	private final double price;

	public Price(final double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Price: " + Double.toString(price);
	}

	@Override
	public boolean equals(final Object obj) {
		return ((Price) obj).price == price;
	}

	@Override
	public int hashCode() {
		return new Double(price).hashCode();
	}

	public Price lowestPrice(final Price other) {
		return new Price(Math.min(price, other.price));
	}

	public Price add(final Price other) {
		return new Price(price + other.price);
	}

}
