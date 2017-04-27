
public class Eircode {
	private String eircode = null;
	private String candidateEircode = null;
	
	public Eircode(String e){
		super();
		
		candidateEircode = generateCanonicalEircode(e);

		if (candidateEircode.length() < 7)
			throw new IllegalArgumentException("Input eircode too short: " + candidateEircode.length());

		if (candidateEircode.length() > 7)
			throw new IllegalArgumentException("Input eircode too long: " + candidateEircode.length());
		this.eircode = candidateEircode;
	}
	
	private String generateCanonicalEircode(String nonCanonicalEircode) {
		String CanonicalEircode = nonCanonicalEircode.replaceAll("\\s+", "");
		CanonicalEircode = CanonicalEircode.toUpperCase();
		return CanonicalEircode;
	}
	
	
	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
	
}
