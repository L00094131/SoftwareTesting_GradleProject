import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanTests {
	private Human testDummy = new Human("Joe", "Bloggs", "Deerpark", 140, 160, 23);

	@Test
	public void testGetFirstName() {
		assertEquals("Joe", testDummy.getFName());
	}

	@Test
	public void testGetSecondName() {
		assertEquals("Bloggs", testDummy.getLName());
	}

	@Test
	public void testGetSecondName3() {
		assertEquals("Bloggs", testDummy.getLName());
	}
	

}
