package demo;

import java.util.Date;
import java.util.Objects;

public class Persona {
	String nome;
	String cognome;
	Date data_nascita;
	int eta;

	// CONSTRUCTOR
	public Persona(String nome, String cognome, Date data_nascita, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
		this.eta = eta;
	}

	// OVERRIDE
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", data_nascita=" + data_nascita + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, data_nascita, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(data_nascita, other.data_nascita)
				&& Objects.equals(nome, other.nome);
	}

	// GETTER & SETTER
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getEta() {
		return this.eta;
	}

}
