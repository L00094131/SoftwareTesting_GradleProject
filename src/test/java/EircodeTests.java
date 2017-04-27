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

	private Eircode myEircode;
	private Eircode validEircode1 = new Eircode ("f92 f1w8");
	private Address validAddress1 = new Address(validEircode1, "Ireland", "Donegal", "Burt");
	private AddressProvider provider;
	
	@Before
	public void setUpEircode() {
		myEircode = new Eircode("F92 F1W8");
	}

	@Test
	public void testGetEircode1() {
		myEircode.setEircode("F92 F1W8");
		assertEquals("F92 F1W8", myEircode.getEircode());
	}
	
	// Test Eircode class using JUnit
	@Test
	public void testGetEircode() {
		assertEquals("F92F1W8", validEircode1.getEircode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooLong() {
		
		new Eircode("F92 F1W81");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooShort() {
		new Eircode("F92 F1W");
	}
	
	@Before
	public void setUp() {
		provider = Mockito.mock(AddressProvider.class);
		when(provider.getAddress(validEircode1)).thenReturn(validAddress1);
	}

	@Test
	public void testCountryInProvidedAddress() {
		Address testAddress = provider.getAddress(validEircode1);
		// Hamcrest test
		assertThat(testAddress.getCountry(), is(equalTo("Ireland")));
	}

	@Test
	public void testCompleteAddress() {
		Address testAddress = provider.getAddress(validEircode1);

		// Do the test, hamcrest matching.
		assertThat(testAddress, is(equalTo(validAddress1)));
	}

	@Test
	public void testCompleteAddress2() {
		Address testAddress = provider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingFieldByField(validAddress1);
	}

	@Test
	public void testCompleteAddress3() {
		Address testAddress = provider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingOnlyGivenFields(validAddress1, "country");
	}

	@Test
	public void testCompleteAddress4() {
		Address testAddress = provider.getAddress(validEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).hasFieldOrPropertyWithValue("county", "Donegal");
	}

}
