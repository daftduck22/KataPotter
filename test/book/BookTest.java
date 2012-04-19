package book;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

	@Test
	public void testToString() {
		Assert.assertEquals("Book: 1", new Book(1).toString());
		Assert.assertEquals("Book: 2", new Book(2).toString());
		Assert.assertEquals("Book: 3", new Book(3).toString());
		Assert.assertEquals("Book: 4", new Book(4).toString());
		Assert.assertEquals("Book: 5", new Book(5).toString());
	}

	@Test
	public void testEquals() {
		Assert.assertTrue(new Book(1).equals(new Book(1)));
		Assert.assertTrue(new Book(2).equals(new Book(2)));

		Assert.assertFalse(new Book(1).equals(new Book(2)));
		Assert.assertFalse(new Book(2).equals(new Book(1)));
	}

	@Test
	public void testHashcode() {
		Assert.assertEquals(new Book(1).hashCode(), new Book(1).hashCode());
		Assert.assertEquals(new Book(2).hashCode(), new Book(2).hashCode());

		Assert.assertNotSame(new Book(1).hashCode(), new Book(2).hashCode());
		Assert.assertNotSame(new Book(2).hashCode(), new Book(1).hashCode());
	}
}
