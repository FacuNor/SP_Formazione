package listtomap;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public interface IListMap {
	
	//Utilizza loop old style sulla lista
	Map<String, Book> listToMapOldStyle(List<Book> list);
	
	//Utilizza la notazione lambda
	Map<String, Book> listToMapWithLambda(List<Book> list);
	
	//Utilizza il method reference operator invece di lambda
	Map<String, Book> listToMapWithReference(List<Book> list);
	
	//Non Gestisce i duplicati
	Map<String, Book> listToMapWithFunctionIdentity(List<Book> list);
	
	//Gestisce i duplicati con una List come value
	Map<String, List<Book>> listToMapWithNoDuplicateList(List<Book> list);
	
	//Gestisce i duplicati senza una List come value
	Map<String, Book> listToMapWithNoDuplicate(List<Book> list);
	
	//Restituisce i nomi dei book con isbn > di uno fornito
	Map<String, List<Book>> listToMapIsbnGreaterThen(List<Book> books,String isbn);
	
	//Restituisce i nomi dei book in un unica stringa [libro 1,libro 2, libro 3]
	String bookNamesJoined(List<Book> books);
	
	//Restituisce il prezzo medio di tutti i libri
	double averageBookPrize(List<Book> books);
	
	//Restituisce il costo totale per acquistare tutti i libri forniti
	double totalCost(List<Book> books);
	
	//Restituisce le statistice dei libri di input
	DoubleSummaryStatistics bookStatistics(List<Book> books);
	
	//Restituisce tutti gli autori
	String[] bookAuthors(List<Book> books);
	
	//Restituisce tutti gli autori di una determinata nazione
	String[] bookAuthors(List<Book> books,String nazione);
	
}
