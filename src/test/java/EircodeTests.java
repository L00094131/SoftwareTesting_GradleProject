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
	private Eircode eircode1 = new Eircode ("f92 f1w8");
	private Eircode eircode2 = new Eircode ("F92 FC93");
	private Address address1 = new Address(eircode1, "Ireland", "Donegal", "Burt");
	private Address address2 = new Address(eircode2, "Ireland", "Donegal", "Letterkenny");
	private AddressProvider provider;
	
	// Test Eircode class using JUnit
	@Before
	public void setUpEircode() {
		myEircode = new Eircode("f92 f1w8");
	}

	@Test
	public void testGetEircode() {
		assertEquals("F92F1W8", myEircode.getEircode());
	}
	
	@Test
	public void testSetEircode() {
		myEircode.setEircode("F92F1W8");
		assertEquals("F92F1W8", myEircode.getEircode());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEircodeLowercase() {
		myEircode.setEircode("f92 f1w8");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEircodeTooShort() {
		myEircode.setEircode("f92f1w");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEircodeTooLong() {
		myEircode.setEircode("f92f1w88");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooLong() {
		new Eircode("F92 F1W81");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooShort() {
		new Eircode("F92 F1W");
	}
	
	// Mockito testing
	@Before
	public void setUp() {
		provider = Mockito.mock(AddressProvider.class);
		when(provider.getAddress(eircode1)).thenReturn(address1);
		when(provider.getAddress(eircode2)).thenReturn(address2);
	}

	@Test
	public void testCountryInProvidedAddress() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress.getCountry(), is(equalTo("Ireland")));
	}
	
	@Test
	public void testCountyInProvidedAddress() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress.getCounty(), is(equalTo("Donegal")));
	}
	
	@Test
	public void testTownInProvidedAddress() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress.getTown(), is(equalTo("Burt")));
	}

	@Test
	public void testCompleteAddress() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress, is(equalTo(address1)));
	}

	@Test
	public void testAddressFields() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress).isEqualToComparingOnlyGivenFields(address1, "town");
	}

	@Test
	public void testPropertyWithinAddress() {
		Address testAddress = provider.getAddress(eircode1);
		assertThat(testAddress).hasFieldOrPropertyWithValue("country", "Ireland");
	}

}
