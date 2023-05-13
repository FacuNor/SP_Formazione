package rubricaEs3_4;

import java.io.Serializable;

public class SchedaPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String indirizzo;
	private String numero;

	// CONSTUCTORS
	public SchedaPersona() {
		this.nome="";
		this.indirizzo="";
		this.numero="";
	}
	public SchedaPersona(String nome, String indirizzo, String numero) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numero = numero;
	}

	// OVERRIDE METHODS
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SchedaPersona other = (SchedaPersona) obj;
		return this.nome.trim().equalsIgnoreCase(other.getNome().trim()) 
				&& this.numero.trim().equals(other.getNumero().trim())
				&& this.indirizzo.trim().equalsIgnoreCase(other.getIndirizzo().trim());
	}

	@Override
	public String toString() {
		return "SchedaPersona [nome=" + nome + ", indirizzo=" + indirizzo + ", numero=" + numero + "]";
	}

	// OTHER METHOD
	public boolean contains(String s) {
		if(s==null||s.isBlank()||s.isEmpty()) {
			return false;
		}
		if(this.nome.toUpperCase().trim().contains(s.toUpperCase().trim())) {
			return true;
		}
		if(this.numero.toUpperCase().trim().contains(s.toUpperCase().trim())) {
			return true;
		}
		if(this.indirizzo.toUpperCase().trim().contains(s.toUpperCase().trim())) {
			return true;
		}
		return false;
	}

	// GETTER & SETTER
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @param indirizzo the indirizzo to set
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
