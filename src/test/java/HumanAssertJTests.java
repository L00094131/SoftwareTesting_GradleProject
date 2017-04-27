import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class HumanAssertJTests {
	private Human myHuman;

	@Before
	public void setUpHuman() {
		myHuman = new Human("Billy-Bob", "Thornton", 160, 195.5, 61, 61, Gender.MALE);
	}

	// First name tests
	@Test
	public void testStartAndEndFName() {
		assertThat(myHuman.getFName()).startsWith("Billy");
		assertThat(myHuman.getFName()).endsWith("Bob");
	}
	
	@Test 
	public void testContainsHyphenOnce(){
		assertThat(myHuman.getFName()).containsOnlyOnce("-");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContainsHyphenTwice(){
		myHuman.setFName("Billy--Bob");
		assertThat(myHuman.getFName()).contains("--");
	}

	@Test
	public void testIsEqualToFName() {
		assertThat(myHuman.getFName()).isEqualToIgnoringCase("billy-bob").hasSize(9);
	}

	@Test 
	public void testFNameNotEmpty(){
		assertThat(myHuman.getFName()).isNotEmpty();
	}
	
	// Second name tests
	@Test
	public void testStartAndEndLName() {
		assertThat(myHuman.getLName()).startsWith("Thorn");
		assertThat(myHuman.getLName()).endsWith("ton");
	}
	
	@Test
	public void testLNameContains(){
		assertThat(myHuman.getLName()).contains("Thorn", "ton");
		assertThat(myHuman.getLName()).containsOnlyOnce("r");
	}
	
	@Test
	public void testLNameNotEqualToFName(){
		assertThat(myHuman.getLName()).isNotEqualTo(myHuman.getFName());
	}

	// Testing gender
	@Test
	public void testGenderContains(){
		assertThat(myHuman).extracting("gender").contains(Gender.MALE);
	}
}
