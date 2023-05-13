package rubricaEs5_6;

public class SchedaPersona implements IScheda {

	private String nome;
	private String indirizzo;
	private String numero;

	// CONSTUCTORS
	public SchedaPersona() {
		this.nome = "";
		this.indirizzo = "";
		this.numero = "";
	}

	public SchedaPersona(String nome, String indirizzo, String numero) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numero = numero;
	}

	// OVERRIDE METHODS
	@Override
	public boolean equals(Object s) {
		if (this == s) {
			return true;
		}
		if (s == null) {
			return false;
		}
		if (getClass() != s.getClass()) {
			return false;
		}
		SchedaPersona other = (SchedaPersona) s;
		return this.nome.trim().equalsIgnoreCase(other.getNome().trim())
				&& this.numero.trim().equals(other.getNumero().trim())
				&& this.indirizzo.trim().equalsIgnoreCase(other.getIndirizzo().trim());
	}

	@Override
	public String toString() {
		return "SchedaPersona [nome=" + nome + ", indirizzo=" + indirizzo + ", numero=" + numero + "]";
	}

	@Override
	public boolean contains(String s) {
		if (s == null || s.isBlank() || s.isEmpty()) {
			return false;
		}
		return this.nome.toUpperCase().trim().contains(s.toUpperCase().trim())
				|| this.numero.toUpperCase().trim().contains(s.toUpperCase().trim())
				|| this.indirizzo.toUpperCase().trim().contains(s.toUpperCase().trim());
	}

	// GETTER & SETTER
	/**
	 * @return the nome
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the indirizzo
	 */
	@Override
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	@Override
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the numero
	 */
	@Override
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	@Override
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
