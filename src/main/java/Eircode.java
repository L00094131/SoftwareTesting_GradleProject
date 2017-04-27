
public class Eircode {
	private String eircode;
	private String candidateEircode;

	public Eircode(String e) {
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
		if (eircode.length() < 7) {
			throw new IllegalArgumentException("Eircode too short");
		}
		if (eircode.length() > 7) {
			throw new IllegalArgumentException("Eircode too long");
		} else {
			eircode.toUpperCase();
			eircode.replaceAll("\\s+", "");
			this.eircode = eircode;
		}
	}

}
