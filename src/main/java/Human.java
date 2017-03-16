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

	public void setFName(String fname) {
		this.fname = fname;
	}

	public String getLName() {
		return lname;
	}

	public void setLName(String lname) {
		this.lname = lname;
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
		if (weight > 350 || weight < 0) {
			throw new IllegalArgumentException("Weight must be within the range 0-350lbs");
		} else {
			this.weight = weight;
		}
	}

	public int getHeightInCentimeters() {
		return height;
	}

	public void setHeightInCentimeters(int height) {
		if (height > 275 || height < 0) {
			throw new IllegalArgumentException("Height must be within the range 0-275cm");
		}else{
			this.height = height;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0){
			throw new IllegalArgumentException("Age cannot be negative");
		}else{
			this.age = age;
		}
	}

}