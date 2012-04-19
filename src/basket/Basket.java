package basket;

import java.util.ArrayList;
import java.util.List;

import book.Book;

public class Basket {

	List<Book> books = new ArrayList<Book>();

	public Basket(final Book... books) {
		for (final Book book : books) {
			this.books.add(book);
		}
	}

	public void howMany(final BasketQuantityListener listener) {
		listener.numberOfBooks(books.size());
	}

	public void atLeastUniqueBooks(final int numberOfUniqueBooks, final BasketContentsListener listener) {
		final List<Book> newBooks = new ArrayList<Book>();
		newBooks.addAll(books);

		int numUnique = 0;
		for (int i = 1; i < 6 && numUnique < numberOfUniqueBooks; i++) {
			if (newBooks.contains(new Book(i))) {
				newBooks.remove(new Book(i));
				numUnique++;
			}
		}

		if (numUnique == numberOfUniqueBooks) {
			listener.basketLessUniqueBooks(new Basket(newBooks.toArray(new Book[newBooks.size()])));
		}
	}

	@Override
	public String toString() {
		return books.toString();
	}

}
