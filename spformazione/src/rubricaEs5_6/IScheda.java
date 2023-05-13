package rubricaEs5_6;

public interface IScheda {

	void setNome(String nome);
	void setIndirizzo(String indirizzo);
	void setNumero(String numero);
	
	String getNome();
	String getIndirizzo();
	String getNumero();
	
	boolean contains(String s);
	boolean equals(Object s);
}
