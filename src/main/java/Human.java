/**
 * @author Eugene
 *
 */
public final class Human {

	private String fname;
	private String lname;
	private String address;
	private int weight;
	private int height;
	private int age;

	public Human() {
		fname = null;
		lname = null;
		address = null;
		weight = 0;
		height = 0;
		age = 0;
	}

	public Human(String fn, String ln, String a, int w, int h, int ag) {
		fname = fn;
		lname = ln;
		address = a;
		weight = w;
		height = h;
		age = ag;
	}

	public String getFName() {
		return fname;
	}
	
	public String getLName() {
		return lname;
	}

	/*
	 * regex for first name allows for hyphenated names names with apostrophes
	 * names with spaces Irish names with fadas
	 * 
	 */

	public static boolean validateFName(String fname) {
		return fname.matches("[a-zA-záéíóú]+([ '-][a-zA-Z]+)*");
	}
	
	/*
	 * regex for last name allows for hyphenated names names with apostrophes
	 * names with spaces Irish names with fadas, names with commas and full stops
	 * 
	 */
	public static boolean validateLName(String lname) {
		return lname.matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}");
	}
	

	public void setFName(String fname) {
		if (validateFName(fname) == true) {
			this.fname = fname;
		} else {
			throw new IllegalArgumentException("First name can only be alphabetic with apostrophe or hyphen.",
					null);
		}

	}


	public void setLName(String lname) {
		if (validateLName(lname) == true) {
			this.lname = lname;
		} else {
			throw new IllegalArgumentException("Last name can only be alphabetic with apostrophe or hyphen.",
					null);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWeightInPounds() {
		return weight;
	}

	public void setWeightInPounds(int weight) {
		if (weight > 350 || weight < 1) {
			throw new IllegalArgumentException("Weight must be within the range 0-350lbs");
		} else {
			this.weight = weight;
		}
	}

	public int getHeightInCentimeters() {
		return height;
	}

	public void setHeightInCentimeters(int height) {
		if (height > 275 || height < 20) {
			throw new IllegalArgumentException("Height must be within the range 0-275cm");
		} else {
			this.height = height;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 130 || age < 0) {
			throw new IllegalArgumentException("Age must be within the range 0-130 years");
		} else {
			this.age = age;
		}
	}

}