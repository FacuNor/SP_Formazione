package listtomap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListToMapTest {

	static List<Book> books;
	static Map<String, Book> result;
	static ListToMap test;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		books = new ArrayList<>();
		books.add(new Book("001", "Harry Potter", "Rowling","Inghilterra",15));
		books.add(new Book("002", "Il signore degli anelli", "Tolkien","Inghilterra",22));
		books.add(new Book("003", "Le intermittenze della morte", "Saramago","Portogallo",8));

		result = new HashMap<>();
		for (Book book : books) {
			result.put(book.getIsbn(), book);
		}

		test = new ListToMap();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void listToMapOldStyleTest() {
		// NESSUN PROBLEMA ESPLICITO PER I DUPLICATI: 
		//VENGONO GESTITI DALLA PUT ESPLICITA-> IL SECONDO VALORE SOSTITUISCE IL PRIMO
		books.add(new Book("001", "Harry Potter 2", "Rowling","Inghilterra",15));
		assertEquals(test.listToMapOldStyle(books).keySet().size(), result.keySet().size());
		assertTrue(result.keySet().containsAll(test.listToMapOldStyle(books).keySet()));
		assertEquals(test.listToMapOldStyle(books).values().size(), result.values().size());
		assertTrue(Arrays.asList(new Book("003", "Le intermittenze della morte", "Saramago","Portogallo",8),new Book("002", "Il signore degli anelli", "Tolkien","Inghilterra",22),new Book("001", "Harry Potter 2", "Rowling","Inghilterra",15)).containsAll(test.listToMapOldStyle(books).values()));
	}

	@Test
	void listToMapWithLambdaTest() {
		//PROBLEMA CON I DUPLICATI
		// books.add(new Book("001", "Harry Potter 2", "Rowling"));
		assertEquals(test.listToMapWithLambda(books).keySet().size(), result.keySet().size());
		assertTrue(result.keySet().containsAll(test.listToMapWithLambda(books).keySet()));
		assertEquals(test.listToMapWithLambda(books).values().size(), result.values().size());
		assertTrue(result.values().containsAll(test.listToMapWithLambda(books).values()));
	}

	@Test
	void listToMapWithReferenceTest() {
		//PROBLEMA CON I DUPLICATI
		// books.add(new Book("001", "Harry Potter 2", "Rowling"));
		assertEquals(test.listToMapWithReference(books).keySet().size(), result.keySet().size());
		assertTrue(result.keySet().containsAll(test.listToMapWithReference(books).keySet()));
		assertEquals(test.listToMapWithReference(books).values().size(), result.values().size());
		assertTrue(result.values().containsAll(test.listToMapWithReference(books).values()));
	}

	@Test
	void listToMapWithFunctionIdentityTest() {
		//PROBLEMA CON I DUPLICATI
		// books.add(new Book("001", "Harry Potter 2", "Rowling"));
		assertEquals(test.listToMapWithFunctionIdentity(books).keySet().size(), result.keySet().size());
		assertTrue(result.keySet().containsAll(test.listToMapWithFunctionIdentity(books).keySet()));
		assertEquals(test.listToMapWithFunctionIdentity(books).values().size(), result.values().size());
		assertTrue(result.values().containsAll(test.listToMapWithFunctionIdentity(books).values()));
	}

	@Test
	void listToMapWithNoDuplicateListTest() {
		// NESSUN PROBLEMA CON I DUPLICATI: VENGONO GESTITI -> PER OGNI CHIAVE CI SONO PIU' ELEMENTI
		books.add(new Book("001", "Harry Potter 2", "Rowling","Inghilterra",15));
		
		assertEquals(test.listToMapWithNoDuplicateList(books).keySet().size(),3);
		assertTrue(test.listToMapWithNoDuplicateList(books).keySet().containsAll(result.keySet()));
		
		assertTrue(test.listToMapWithNoDuplicateList(books).get("001").containsAll(Arrays.asList(new Book("001", "Harry Potter", "Rowling","Inghilterra",15),new Book("001", "Harry Potter 2", "Rowling","Inghilterra",15))));
		assertEquals(test.listToMapWithNoDuplicateList(books).get("001").size(), 2);
		
		assertTrue(test.listToMapWithNoDuplicateList(books).get("002").containsAll(Arrays.asList(new Book("002", "Il signore degli anelli", "Tolkien","Inghilterra",22))));
		assertEquals(test.listToMapWithNoDuplicateList(books).get("002").size(), 1);
		
		assertTrue(test.listToMapWithNoDuplicateList(books).get("003").containsAll(Arrays.asList(new Book("003", "Le intermittenze della morte", "Saramago","Portogallo",8))));
		assertEquals(test.listToMapWithNoDuplicateList(books).get("003").size(), 1);
	}

	@Test
	void listToMapWithNoDuplicateTest() {
		// NESSUN PROBLEMA CON I DUPLICATI: VENGONO GESTITI DA ME
		books.add(new Book("001", "Harry Potter 2", "Rowling","Inghilterra",15)); 
		assertEquals(test.listToMapWithNoDuplicate(books).keySet().size(), result.keySet().size());
		assertTrue(result.keySet().containsAll(test.listToMapWithNoDuplicate(books).keySet()));
		assertEquals(test.listToMapWithNoDuplicate(books).values().size(), result.values().size());
		assertTrue(result.values().containsAll(test.listToMapWithNoDuplicate(books).values()));
	}
	
	@Test
	void listToMapIsbnGreaterThenTest() {
		assertTrue(test.listToMapIsbnGreaterThen(books, "001").keySet().containsAll(Arrays.asList("002","003")));
		assertEquals(test.listToMapIsbnGreaterThen(books, "001").keySet().size(), Arrays.asList("002","003").size());
		
		assertTrue(test.listToMapIsbnGreaterThen(books, "001").get("002").containsAll(Arrays.asList(new Book("002", "Il signore degli anelli", "Tolkien","Inghilterra",22))));
		assertEquals(test.listToMapIsbnGreaterThen(books, "001").get("002").size(), 1);
		
		assertTrue(test.listToMapIsbnGreaterThen(books, "001").get("003").containsAll(Arrays.asList(new Book("003", "Le intermittenze della morte", "Saramago","Portogallo",8))));
		assertEquals(test.listToMapIsbnGreaterThen(books, "001").get("003").size(), 1);
	} 
	
	@Test
	void bookNamesJoinedTest() {
		String resultString = "[Harry Potter, Il signore degli anelli, Le intermittenze della morte]";
		assertEquals(resultString, test.bookNamesJoined(books));
	}
	
	@Test
	void averageBookPrizeTest() {
		assertEquals(test.averageBookPrize(books), 15.0);
	}
	
	@Test
	void totalCostTest() {
		assertEquals(test.totalCost(books), 45);
	}

	@Test
	void bookStatisticsTest() {
		
		assertEquals(test.bookStatistics(books).getAverage(),15);
		assertEquals(test.bookStatistics(books).getCount(),3);
		assertEquals(test.bookStatistics(books).getMax(),22);
		assertEquals(test.bookStatistics(books).getMin(),8);
		assertEquals(test.bookStatistics(books).getSum(),45);
	}
	
	@Test
	void bookAuthorsTest() {
		String[] resultStrings = {"Rowling","Tolkien","Saramago"};
		assertTrue(Arrays.asList(resultStrings).containsAll(Arrays.asList(test.bookAuthors(books))));
		assertEquals(resultStrings.length, test.bookAuthors(books).length);
	}
	
	@Test
	void bookNationAuthorsTest() {
		String[] resultStrings = {"Rowling","Tolkien"};
		assertTrue(Arrays.asList(resultStrings).containsAll(Arrays.asList(test.bookAuthors(books,"Inghilterra"))));
		assertEquals(resultStrings.length, test.bookAuthors(books,"Inghilterra").length);
	}
}
