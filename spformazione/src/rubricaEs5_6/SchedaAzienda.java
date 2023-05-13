package rubricaEs5_6;

public class SchedaAzienda extends SchedaPersona /*implements IScheda*/ {

	private String numeroFax;

	// CONSTRUCTORS
	public SchedaAzienda() {
		super();
		this.numeroFax = "";
	}

	public SchedaAzienda(String nome, String indirizzo, String numero, String numeroFax) {
		super(nome, indirizzo, numero);
		this.numeroFax = numeroFax;
	}

	// GETTER & SETTER
	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getNumeroFax() {
		return this.numeroFax;
	}

	@Override
	public boolean equals(Object s) {
		if(super.equals(s)) {
			SchedaAzienda other = (SchedaAzienda)s;
			return this.numeroFax.trim().equalsIgnoreCase(other.getNumeroFax());
		}
		return false;
		/*if (this == s) {
			return true;
		}
		if (s == null) {
			return false;
		}
		if (getClass() != s.getClass()) {
			return false;
		}
		SchedaAzienda other = (SchedaAzienda) s;
		return this.getNome().trim().equalsIgnoreCase(other.getNome().trim())
				&& this.getNumero().trim().equals(other.getNumero().trim())
				&& this.getIndirizzo().trim().equalsIgnoreCase(other.getIndirizzo().trim())
				&& this.numeroFax.trim().equalsIgnoreCase(other.getNumeroFax());*/
	}

	@Override
	public boolean contains(String s) {

		if (!super.contains(s)) {
			return this.numeroFax.toUpperCase().trim().contains(s.toUpperCase().trim());
		}
		return true;
	}

	@Override
	public String toString() {
		return "SchedaAzienda [nome=" + this.getNome() + ", indirizzo=" + this.getIndirizzo() + ", numero="
				+ this.getNumero() + ", numeroFax=" + this.numeroFax + "]";
	}

}
