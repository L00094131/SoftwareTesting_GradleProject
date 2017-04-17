
public class Address {
	private String country;
	private String county;
	private String town;
	private Eircode eircode = null;
	
	public Address(String country, Eircode eircode, String county, String town){
		this.country=country;
		this.eircode= eircode;
		this.county=county;
		this.town=town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Eircode getEircode() {
		return eircode;
	}

	public void setEircode(Eircode eircode) {
		this.eircode = eircode;
	}
	
}
