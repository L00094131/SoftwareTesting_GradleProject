import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;



public class EircodeTests {


	private Eircode validEircode1 = new Eircode ("F92 F1W8");
	private Address validAddress1 = new Address("Ireland", validEircode1, "Donegal", "Burt");
	private AddressProvider testProvider;

	// Test Eircode
	@Test
	public void testGetEircode() {
		assertEquals("F92F1W8", validEircode1.getEircode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooLong() {
		final Eircode invalidTooLong = new Eircode("F92 F1W81");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooShort() {
		final Eircode invalidTooShort = new Eircode("F92 F1W");
	}

	@Before
	public void setUp() {
		testProvider = Mockito.mock(AddressProvider.class);
		when(testProvider.getAddress(validEircode1)).thenReturn(validAddress1);
	}

	@Test
	public void testCountryInProvidedAddress() {
		Address testAddress = testProvider.getAddress(validEircode1);
		// Hamcrest test
		assertThat(testAddress.getCountry(), is(equalTo("Ireland")));
	}

	@Test
	public void testCompleteAddress() {
		Address testAddress = testProvider.getAddress(validEircode1);

		// Do the test, hamcrest matching.
		assertThat(testAddress, is(equalTo(validAddress1)));
	}

	@Test
	public void testCompleteAddress2() {
		Address testAddress = testProvider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingFieldByField(validAddress1);
	}

	@Test
	public void testCompleteAddress3() {
		Address testAddress = testProvider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingOnlyGivenFields(validAddress1, "country");
	}

	@Test
	public void testCompleteAddress4() {
		Address testAddress = testProvider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).hasFieldOrPropertyWithValue("county", "Donegal");
	}

}
