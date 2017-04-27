
public class Address {
	private String country;
	private String county;
	private String town;
	
	public Address(Eircode eircode, String country, String county, String town){
		this.country=country;
		this.county=county;
		this.town=town;
	}

	public String getCountry() {
		return country;
	}

	/*
	 * regex for country and county allows for hyphenated names names with apostrophes
	 */
	public static boolean validateCountryAndCounty(String country) {
		return country.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	}
	
	public void setCountry(String country) {
		if (validateCountryAndCounty(country) == true) {
			this.country = country;
		}else{
			throw new IllegalArgumentException("Country name can only be alphabetic.", null);
		}
	}
	
	public static boolean validateCountySize(String county) {
		if(county.length() <= 11 && county.length() >= 4){
			return true;
		}
		return false;
	}
	
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		if (validateCountryAndCounty(county) == true && validateCountySize(county)==true) {
			this.county = county;
		}else{
			throw new IllegalArgumentException("County name can only be alphabetic.", null);
		}
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	
}
