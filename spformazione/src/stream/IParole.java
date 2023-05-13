package stream;

public interface IParole {

	//Restituisce il numero di parole presenti
	public int countAll();
	
	//Restituisce tutte le parole presenti nel file
	public String[] parole();
	
	//Restituisce il numero di occorrenze della parola
	public int count(String parola);
	
	//Restituisce la parola alfabeticamente più grande
	public String parolaMax();
	
	//Restituisce tutte le parole con meno di n caratteri
	public String[] parolaLenghtLess(int numChar);
}
