package price;

import org.junit.Assert;
import org.junit.Test;

public class PriceTest {

	@Test
	public void testToString() {
		Assert.assertEquals("Price: 8.0", new Price(8).toString());
		Assert.assertEquals("Price: 32.0", new Price(32).toString());
		Assert.assertEquals("Price: 123.45", new Price(123.45).toString());
	}

	@Test
	public void testEquals() {
		Assert.assertTrue(new Price(1).equals(new Price(1)));
		Assert.assertTrue(new Price(2).equals(new Price(2)));

		Assert.assertFalse(new Price(1).equals(new Price(2)));
		Assert.assertFalse(new Price(2).equals(new Price(1)));
	}

	@Test
	public void testHashcode() {
		Assert.assertEquals(new Price(1).hashCode(), new Price(1).hashCode());
		Assert.assertEquals(new Price(2).hashCode(), new Price(2).hashCode());

		Assert.assertNotSame(new Price(1).hashCode(), new Price(2).hashCode());
		Assert.assertNotSame(new Price(2).hashCode(), new Price(1).hashCode());
	}

	@Test
	public void lowestPrice() {
		Assert.assertEquals(new Price(1), new Price(1).lowestPrice(new Price(2)));
		Assert.assertEquals(new Price(1), new Price(2).lowestPrice(new Price(1)));
		Assert.assertEquals(new Price(1), new Price(1).lowestPrice(new Price(1)));
		Assert.assertEquals(new Price(2), new Price(2).lowestPrice(new Price(2)));
	}

	@Test
	public void addPrice() {
		Assert.assertEquals(new Price(3), new Price(1).add(new Price(2)));
		Assert.assertEquals(new Price(3), new Price(2).add(new Price(1)));
		Assert.assertEquals(new Price(2), new Price(1).add(new Price(1)));
		Assert.assertEquals(new Price(4), new Price(2).add(new Price(2)));
	}
}
