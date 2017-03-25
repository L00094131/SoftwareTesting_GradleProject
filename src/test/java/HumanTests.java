import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanTests {
	private Human myHuman = new Human("Joe", "Bloggs", "Deerpark", 140, 185, 23);

	// First name tests
	@Test
	public void testGetFirstName() {
		assertEquals("Joe", myHuman.getFName());
	}

	@Test
	public void testHypenatedFirstName() {
		myHuman.setFName("John-Joe");
		assertEquals("John-Joe", myHuman.getFName());
	}

	@Test
	public void testDoubleHypenatedFirstName() {
		myHuman.setFName("John-James-Martin");
		assertEquals("John-James-Martin", myHuman.getFName());
	}

	@Test
	public void testFirstNameWithSpace() {
		myHuman.setFName("John Paul");
		assertEquals("John Paul", myHuman.getFName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFailedDoubleHypenatedFirstName() {
		myHuman.setFName("John--Joe");
		assertEquals("John--Joe", myHuman.getFName());
	}

	@Test
	public void testApostrophesFirstName() {
		myHuman.setFName("D'Angelo");
		assertEquals("D'Angelo", myHuman.getFName());
	}

	@Test
	public void testSingleFadaIrishFirstName() {
		myHuman.setFName("Bláthnaid");
		assertEquals("Bláthnaid", myHuman.getFName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetFirstNameWithSymbol() {
		myHuman.setFName("€ugene");
		assertEquals("€ugene", myHuman.getFName());
	}

	@Test
	public void testDoubleFadaIrishFirstName() {
		myHuman.setFName("Bláthnaíd");
		assertEquals("Bláthnaíd", myHuman.getFName());
	}

	@Test
	public void testFadaWithApostropheIrishFirstName() {
		myHuman.setFName("Séan'Og");
		assertEquals("Séan'Og", myHuman.getFName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetFirstNameWithNumber() {
		myHuman.setFName("J0hn");
		assertEquals("J0hn", myHuman.getFName());
	}

	@Test
	public void testSetFirstName() {
		myHuman.setFName("Eugene");
		assertEquals("Eugene", myHuman.getFName());
	}

	// Second name tests
	@Test
	public void testGetLastName() {
		assertEquals("Bloggs", myHuman.getLName());
	}
	
	@Test
	public void testSetLastName() {
		myHuman.setLName("Robb");
		assertEquals("Robb", myHuman.getLName());
	}
	
	@Test
	public void testSpaceLastName() {
		myHuman.setLName("Mc Grath");
		assertEquals("Mc Grath", myHuman.getLName());
	}
	
	@Test
	public void testHypenatedLastName() {
		myHuman.setLName("Rutherford-Morrison");
		assertEquals("Rutherford-Morrison", myHuman.getLName());
	}
	
	@Test
	public void testDoubleHypenatedLastName() {
		myHuman.setLName("Rutherford-Morrison-Maguire");
		assertEquals("Rutherford-Morrison-Maguire", myHuman.getLName());
	}
	
	@Test
	public void testLastNameWithSpaceCommaFullStop() {
		myHuman.setLName("Luther King, Jr.");
		assertEquals("Luther King, Jr.", myHuman.getLName());
	}

	@Test
	public void testApostropheLastName() {
		myHuman.setLName("O'Toole");
		assertEquals("O'Toole", myHuman.getLName());
	}

	@Test
	public void testSingleFadaIrishLastNameWithSpace() {
		myHuman.setLName("Mac Cearáin ");
		assertEquals("Mac Cearáin ", myHuman.getLName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameWithSymbol() {
		myHuman.setLName("R+bb");
		assertEquals("R+bb", myHuman.getLName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameFullStopAtStart() {
		myHuman.setLName(".Robb");
		assertEquals(".Robb", myHuman.getLName());
	}

	@Test
	public void testFadaIrishLastName() {
		myHuman.setLName("Rób");
		assertEquals("Rób", myHuman.getLName());
	}

	@Test
	public void testFadaWithApostropheIrishLastName() {
		myHuman.setLName("O'Siodhachaín");
		assertEquals("O'Siodhachaín", myHuman.getLName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLastNameWithNumber() {
		myHuman.setLName("R0bb");
		assertEquals("R0bb", myHuman.getLName());
	}


	@Test
	public void testGetAge() {
		assertEquals(23, myHuman.getAge());
	}

	@Test
	public void testSetAge() {
		myHuman.setAge(23);
		assertEquals(23, myHuman.getAge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeNegativeAgeException() {
		myHuman.setAge(-1);
		assertEquals(-1, myHuman.getAge());
	}

	@Test
	public void testGetWeightInPounds() {
		assertEquals(140, myHuman.getWeightInPounds());
	}

	@Test
	public void testSetWeightInPounds() {
		myHuman.setWeightInPounds(160);
		assertEquals(160, myHuman.getWeightInPounds());
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
	public void testGetHeightInCentimeters() {
		assertEquals(185, myHuman.getHeightInCentimeters());
	}

	@Test
	public void testSetHeightInCentimeters() {
		myHuman.setHeightInCentimeters(185);
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
