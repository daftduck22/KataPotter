package book;


public class Book {

	private final int book;

	public Book(final int book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Book: " + Integer.toString(book);
	}

	@Override
	public boolean equals(final Object obj) {
		return ((Book) obj).book == book;
	}

	@Override
	public int hashCode() {
		return new Integer(book).hashCode();
	}

}
