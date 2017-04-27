import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HumanTests {
	private Human myHuman;
	
	@Before
	public void setUpHuman() {
		myHuman = new Human("Joe", "Bloggs", 140, 185.0, 23, 23, Gender.MALE);
	}

	// First name JUnit tests
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

	// Second name JUnit tests
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

	// Hamcrest tests for height 
	@Rule
	public ExpectedException exceptionGrabber = ExpectedException.none();

	@Test
	public void testGetHeightInCentimeters() {
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(185.0)));
	}

	@Test
	public void testSetMiddleHeightInCentimeters() {
		myHuman.setHeightInCentimeters(137.5);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(137.5)));
	}

	@Test
	public void testSetMinHeightInCentimeters() {
		myHuman.setHeightInCentimeters(20.0);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(20.0)));
	}


	@Test
	public void testSetAboveMinHeightInCentimeters() {
		myHuman.setHeightInCentimeters(20.1);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(20.1)));
	}

	@Test
	public void testSetBelowMinHeightInCentimetersException() {
		exceptionGrabber.expect(IllegalArgumentException.class);
		exceptionGrabber.expectMessage(startsWith("Height must be within the range 20.0cm - 275.0cm"));
		myHuman.setHeightInCentimeters(19.9);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(19.9)));
	}

	@Test
	public void testSetMaxHeightInCentimeters() {
		myHuman.setHeightInCentimeters(275.0);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(275.0)));
	}

	@Test
	public void testSetBelowMaxHeightInCentimeters() {
		myHuman.setHeightInCentimeters(274.9);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(274.9)));
	}

	@Test
	public void testSetAboveMaxHeightInCentimetersException() {
		exceptionGrabber.expect(IllegalArgumentException.class);
		exceptionGrabber.expectMessage(startsWith("Height must be within the range 20.0cm - 275.0cm"));
		myHuman.setHeightInCentimeters(275.1);
		assertThat(myHuman.getHeightInCentimeters(), is(equalTo(275.1)));
	}

	// Date of birth JUnit tests
	@Test
	public void testGetAgeFromDateOfBirth() {
		assertEquals(23, myHuman.getAgeFromDateOfBirth());
	}

	@Test
	public void testSetAgeFromDateMiddleAge() {
		LocalDate dateOfBirth = LocalDate.of(1952, 01, 01);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(65, actualDate);
	}

	@Test
	public void testSetAgeFromDateMinAge() {
		LocalDate dateOfBirth = LocalDate.of(2017, 3, 31);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(0, actualDate);
	}

	@Test
	public void testSetAgeFromDateAboveMinAge() {
		LocalDate dateOfBirth = LocalDate.of(2016, 3, 30);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(1, actualDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeFromDateBelowMinAge() {
		LocalDate dateOfBirth = LocalDate.of(2018, 3, 31);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(0, actualDate);
	}

	@Test
	public void testSetAgeFromDateMaxAge() {
		LocalDate dateOfBirth = LocalDate.of(1887, 01, 01);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(130, actualDate);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeFromDateAboveMaxAge() {
		LocalDate dateOfBirth = LocalDate.of(1886, 12, 31);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(131, actualDate);
	}

	@Test
	public void testSetAgeFromDateBelowMaxAge() {
		LocalDate dateOfBirth = LocalDate.of(1888, 01, 01);
		int actualDate = myHuman.setAgeFromDate(dateOfBirth, LocalDate.now());
		assertEquals(129, actualDate);
	}

	// Gender JUnit tests
	@Test
	public void testGetGender() {
		assertEquals(Gender.MALE, myHuman.getGender());
	}
	

	
	@Test
	public void testSetGenderFemale() {
		myHuman.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE, myHuman.getGender());
	}
	
	@Test
	public void testSetGenderMale() {
		myHuman.setGender(Gender.MALE);
		assertEquals(Gender.MALE, myHuman.getGender());
	}

	@Test
	public void testSetGenderOther() {
		myHuman.setGender(Gender.OTHER);
		assertEquals(Gender.OTHER, myHuman.getGender());

	}
	
	@Test
	public void testValueOfGender() {
		Gender.valueOf(Gender.MALE.toString());
	}

}
