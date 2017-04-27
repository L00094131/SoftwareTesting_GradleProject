import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AddressTests {
	private Address myAddress;
	Eircode eircode;
	@Before
	public void setUpHuman() {
		myAddress = new Address(eircode, "Ireland","Donegal","Burt");
	}
	
	@Test
	public void testGetCountry() {
		assertEquals("Ireland", myAddress.getCountry());
	}
	@Test
	public void testSetCountryWithHyphen() {
		myAddress.setCountry("Northern-Ireland");
		assertEquals("Northern-Ireland", myAddress.getCountry());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetCountryWithDigitException() {
		myAddress.setCountry("1reland");
		assertEquals("1reland", myAddress.getCountry());
	}
	
	@Test
	public void testSetCountry() {
		myAddress.setCounty("Donegal");
		assertEquals("Donegal", myAddress.getCounty());
	}
	
	@Test
	public void testSetCountryMaxSize() {
		myAddress.setCounty("Londonderry");
		assertEquals("Londonderry", myAddress.getCounty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetCountryTooBigException() {
		myAddress.setCounty("Londonderrry");
		assertEquals("Londonderrry", myAddress.getCounty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetCountryTooSmallException() {
		myAddress.setCounty("Cor");
		assertEquals("Cor", myAddress.getCounty());
	}
	
	@Test
	public void testSetCountryMinSmall() {
		myAddress.setCounty("Cork");
		assertEquals("Cork", myAddress.getCounty());
	}
	
	
	@Test
	public void testGetCounty() {
		assertEquals("Donegal", myAddress.getCounty());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetCountyWithDigitException() {
		myAddress.setCounty("Doneg4l");
		assertEquals("Doneg4l", myAddress.getCounty());
	}
}
