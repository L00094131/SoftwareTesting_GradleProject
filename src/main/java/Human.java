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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0)
			throw new IllegalArgumentException("Age cannot be negative");
		this.age = age;

	}

}