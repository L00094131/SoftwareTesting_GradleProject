import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanTests {
	private Human myHuman = new Human("Joe", "Bloggs", "Deerpark", 140, 160, 23);

	@Test
	public void testGetFirstName() {
		assertEquals("Joe", myHuman.getFName());
	}

	@Test
	public void testGetSecondName() {
		assertEquals("Bloggs", myHuman.getLName());
	}
	
	
	@Test
	public void testGetAge() {
		assertEquals(23, myHuman.getAge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeNegativeAgeException(){
		myHuman.setAge(-1);
		assertEquals(-1, myHuman.getAge());
	}
		
	
	@Test
	public void testGetWeightInPounds() {
		assertEquals(140, myHuman.getWeightInPounds());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetWeightInPoundsTooHeavyException() {
		myHuman.setWeightInPounds(351);
		assertEquals(351, myHuman.getWeightInPounds());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetWeightInPoundsNegativeWeightException() {
		myHuman.setWeightInPounds(-1);
		assertEquals(-1, myHuman.getWeightInPounds());
	}
	
	
	@Test
	public void testGetHeight() {
		assertEquals(160, myHuman.getHeight());
	}
	

}
