import java.time.LocalDate;
import java.time.Period;

/**
 * @author Eugene
 *
 */

public final class Human {
	
	private String fname;
	private String lname;
	private int weight;
	private double height;
	private int age;
	private int dateOfBirth;
	private Gender gender;

//	public Human() {
//		fname = null;
//		lname = null;
//		weight = 0;
//		height = 0;
//		age = 0;
//		dateOfBirth = 0;
//	}

	public Human(String fn, String ln, int w, double h, int ag, int dob, Gender g) {
		fname = fn;
		lname = ln;
		weight = w;
		height = h;
		age = ag;
		dateOfBirth = dob;
		this.gender = g;

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
	 * names with spaces Irish names with fadas, names with commas and full
	 * stops
	 * 
	 */
	public static boolean validateLName(String lname) {
		return lname.matches("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}");
	}

	public void setFName(String fname) {
		if (validateFName(fname) == true) {
			this.fname = fname;
		} else {
			throw new IllegalArgumentException("First name can only be alphabetic with apostrophe or hyphen.", null);
		}

	}

	public void setLName(String lname) {
		if (validateLName(lname) == true) {
			this.lname = lname;
		} else {
			throw new IllegalArgumentException("Last name can only be alphabetic with apostrophe or hyphen.", null);
		}
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

	public double getHeightInCentimeters() {
		return height;
	}

	public void setHeightInCentimeters(double height) {
		if (height > 275.0 || height < 20.0) {
			throw new IllegalArgumentException("Height must be within the range 20.0cm - 275.0cm");
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

	public int getAgeFromDateOfBirth() {
		return dateOfBirth;
	}

	public int setAgeFromDate(LocalDate birthDate, LocalDate currentDate) {
		LocalDate maxAge = LocalDate.of(1887, 01, 01);
		LocalDate minAge = LocalDate.now();

		if (birthDate.isBefore(maxAge) || birthDate.isAfter(minAge)) {
			throw new IllegalArgumentException("Year must be within todays date and 1887/01/01");
		} else {
			return this.dateOfBirth = Period.between(birthDate, currentDate).getYears();
		}
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}