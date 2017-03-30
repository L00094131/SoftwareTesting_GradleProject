
public class Address {
	private String address;
	private Eircode eircode = null;
	
	public Address(String a, String e){
		address=a;
		this.eircode= new Eircode(e);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
