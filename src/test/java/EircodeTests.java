import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class EircodeTests {


	private Eircode validEircode1 = new Eircode ("F92 F1W8");
	private Address validAddress = new Address("Ireland", validEircode1, "Donegal", "Burt");
	
	
	@Test
	public void testGetEircode(){
		assertEquals("F92F1W8", validEircode1.getEircode());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooLong(){
		final Eircode invalidTooLong = new Eircode("F92 F1W81");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEircodeTooShort(){
		final Eircode invalidTooShort = new Eircode("F92 F1W");
	}
	
}
