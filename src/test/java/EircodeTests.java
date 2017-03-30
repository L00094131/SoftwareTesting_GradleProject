import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EircodeTests {

	private Eircode valid = new Eircode ("F92 F1W8");
	
	@Test
	public void testGetEircode(){
		assertEquals("F92F1W8", valid.getEircode());
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
