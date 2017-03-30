import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanTests {
	private Human myHuman = new Human("Joe", "Bloggs", 140, 185, 23);

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

	// Age tests
	@Test
	public void testGetAge() {
		assertEquals(23, myHuman.getAge());
	}

	@Test
	public void testSetMiddleAge() {
		myHuman.setAge(65);
		assertEquals(65, myHuman.getAge());
	}

	@Test
	public void testSetMinAge() {
		myHuman.setAge(0);
		assertEquals(0, myHuman.getAge());
	}

	@Test
	public void testSetAboveMinAge() {
		myHuman.setAge(1);
		assertEquals(1, myHuman.getAge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetBelowMinAgeException() {
		myHuman.setAge(-1);
		assertEquals(-1, myHuman.getAge());
	}

	@Test
	public void testSetBelowMaxAge() {
		myHuman.setAge(129);
		assertEquals(129, myHuman.getAge());
	}

	@Test
	public void testSetMaxAge() {
		myHuman.setAge(130);
		assertEquals(130, myHuman.getAge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAboveMaxAgeException() {
		myHuman.setAge(131);
		assertEquals(131, myHuman.getAge());
	}

	// Weight tests
	@Test
	public void testGetWeightInPounds() {
		assertEquals(140, myHuman.getWeightInPounds());
	}

	@Test
	public void testSetMiddleWeightInPounds() {
		myHuman.setWeightInPounds(175);
		assertEquals(175, myHuman.getWeightInPounds());
	}

	@Test
	public void testSetMaxWeightInPounds() {
		myHuman.setWeightInPounds(350);
		assertEquals(350, myHuman.getWeightInPounds());
	}

	@Test
	public void testSetBelowMaxWeightInPounds() {
		myHuman.setWeightInPounds(349);
		assertEquals(349, myHuman.getWeightInPounds());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAboveMaxWeightInPoundsException() {
		myHuman.setWeightInPounds(351);
		assertEquals(351, myHuman.getWeightInPounds());
	}

	@Test
	public void testSetMinWeightInPounds() {
		myHuman.setWeightInPounds(1);
		assertEquals(1, myHuman.getWeightInPounds());
	}
	
	@Test
	public void testSetAboveMinWeightInPounds() {
		myHuman.setWeightInPounds(2);
		assertEquals(2, myHuman.getWeightInPounds());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetBelowMinWeightInPoundsException() {
		myHuman.setWeightInPounds(0);
		assertEquals(0, myHuman.getWeightInPounds());
	}

	// Height tests
	@Test
	public void testGetHeightInCentimeters() {
		assertEquals(185, myHuman.getHeightInCentimeters());
	}

	@Test
	public void testSetMiddleHeightInCentimeters() {
		myHuman.setHeightInCentimeters(137);
		assertEquals(137, myHuman.getHeightInCentimeters());
	}
	
	@Test
	public void testSetMinHeightInCentimeters() {
		myHuman.setHeightInCentimeters(20);
		assertEquals(20, myHuman.getHeightInCentimeters());
	}
	
	@Test
	public void testSetAboveMinHeightInCentimeters() {
		myHuman.setHeightInCentimeters(21);
		assertEquals(21, myHuman.getHeightInCentimeters());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetBelowMinHeightInCentimetersException() {
		myHuman.setHeightInCentimeters(19);
		assertEquals(19, myHuman.getHeightInCentimeters());
	}

	@Test
	public void testSetMaxHeightInCentimeters() {
		myHuman.setHeightInCentimeters(275);
		assertEquals(275, myHuman.getHeightInCentimeters());
	}
	
	@Test
	public void testSetBelowMaxHeightInCentimeters() {
		myHuman.setHeightInCentimeters(274);
		assertEquals(274, myHuman.getHeightInCentimeters());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetAboveMaxHeightInCentimetersException() {
		myHuman.setHeightInCentimeters(276);
		assertEquals(276, myHuman.getHeightInCentimeters());
	}

}
