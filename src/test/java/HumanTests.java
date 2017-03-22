import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanTests {
	private Human myHuman = new Human("Joe", "Bloggs", "Deerpark", 140, 185, 23);

	@Test
	public void testGetFirstName() {
		assertEquals("Joe", myHuman.getFName());
	}
	
	@Test
	public void testHypenatedFName() {
		myHuman.setFName("John-Joe");
		assertEquals("John-Joe", myHuman.getFName());
	}
	
	@Test
	public void testFNameWithSpace() {
		myHuman.setFName("John Paul");
		assertEquals("John Paul", myHuman.getFName());
	}
	
	@Test
	public void testDoubleHypenatedFName() {
		myHuman.setFName("John-Joe");
		assertEquals("John-Joe", myHuman.getFName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailedDoubleHypenatedFName() {
		myHuman.setFName("John--Joe");
		assertEquals("John--Joe", myHuman.getFName());
	}
	
	@Test
	public void testApostrophesFName() {
		myHuman.setFName("D'Angelo");
		assertEquals("D'Angelo", myHuman.getFName());
	}
	
	@Test
	public void testSingleFadaIrishFName() {
		myHuman.setFName("Bláthnaid");
		assertEquals("Bláthnaid", myHuman.getFName());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetFNameWithSymbol() {
		myHuman.setFName("€ugene");
		assertEquals("€ugene", myHuman.getFName());
	}
	
	@Test
	public void testDoubleFadaIrishFName() {
		myHuman.setFName("Bláthnaíd");
		assertEquals("Bláthnaíd", myHuman.getFName());
	}
	
	@Test
	public void testFadaWithApostropheIrishFName() {
		myHuman.setFName("Séan'Og");
		assertEquals("Séan'Og", myHuman.getFName());
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetFNameWithNumber() {
		myHuman.setFName("J0hn");
		assertEquals("J0hn", myHuman.getFName());
	}
	

	
	@Test
	public void testSetFirstName() {
		myHuman.setFName("Eugene");
		assertEquals("Eugene", myHuman.getFName());
	}
	

	@Test
	public void testGetSecondName() {
		assertEquals("Bloggs", myHuman.getLName());
	}
	
	@Test
	public void testSetLastName() {
		myHuman.setLName("Robb");
		assertEquals("Robb", myHuman.getLName());
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
	public void testGetHeightInCentimeters(){
		assertEquals(185, myHuman.getHeightInCentimeters());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetHeightInCentimetersNegativeHeightException() {
		myHuman.setHeightInCentimeters(-1);
		assertEquals(-1, myHuman.getHeightInCentimeters());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetHeightInCentimetersTooTallException() {
		myHuman.setHeightInCentimeters(277);
		assertEquals(277, myHuman.getHeightInCentimeters());
	}
	

}
