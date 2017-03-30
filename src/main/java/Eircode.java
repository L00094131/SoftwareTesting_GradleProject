
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
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eircode == null) ? 0 : eircode.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eircode other = (Eircode) obj;
		if (eircode == null) {
			if (other.eircode != null)
				return false;
		} else if (!eircode.equals(other.eircode))
			return false;
		return true;
	}
	
	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
	
}
