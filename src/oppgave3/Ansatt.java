package oppgave3;

public class Ansatt {

	
	public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}

	String fornavn;
	String etternavn;
	Kjonn kjonn;
	String stilling;
	int aarslonn;
	
	public void settaarsLonn(int nyLonn) {
		this.aarslonn = nyLonn;
	}

	public int getaarsLonn() {
		return aarslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [fornavn=" + fornavn + ", etternavn=" + etternavn + ", kjonn=" + kjonn + ", stilling=" + stilling
				+ ", aarslonn=" + aarslonn + "]";
	}

	public String getEtternavn() {
		return etternavn;
	}

	public Kjonn getKjonn() {
		return kjonn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	static boolean erKvinne(Ansatt n) {
		return n.getKjonn() == Kjonn.KVINNE;
	}
	
	static boolean erSjef(Ansatt n) {
		return n.getStilling().contains("Chief");
	}
}
