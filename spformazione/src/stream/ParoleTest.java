package stream;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParoleTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void countAllTest() {
		Parole parole = new Parole("Esempio.txt");
		assertEquals(parole.countAll(), 23);
		
		parole = new Parole(null);
		assertEquals(parole.countAll(), 0);
		
		parole = new Parole("");
		assertEquals(parole.countAll(), 0);
		
		parole = new Parole("	");
		assertEquals(parole.countAll(), 0);
	}
	
	@Test
	void paroleTest() {
		Parole parole = new Parole("Esempio.txt");
		
	 	String[] result = {"Questo","è","un", "file", "di","esempio","di","Arrivederci","Ciao",
	 					"ciao","ciao","mi", "chiamo", "Facundo","e","sto","facendo","una",
	 					"prova","sulle","stream","stream","Facundo"};
	 	assertTrue(Arrays.asList(result).containsAll(Arrays.asList(parole.parole())));
	 	assertEquals(result.length,parole.parole().length);
	 	
	 	
	 	parole = new Parole(null);
	 	assertArrayEquals(new String[0], parole.parole());
	 	
	 	parole = new Parole("");
	 	assertArrayEquals(new String[0], parole.parole());
	 	
	 	parole = new Parole(" ");
	 	assertArrayEquals(new String[0], parole.parole());
	}
	
	@Test
	void countTest() {
		Parole parole = new Parole("Esempio.txt");
		assertEquals(parole.count("FACUNDO"), 2);
		assertEquals(parole.count("CIAO"), 3);
		assertEquals(parole.count("arrivederci"), 1);
		assertEquals(parole.count("Halo"), 0);
		
		assertEquals(parole.count(null), 0);
		assertEquals(parole.count(""), 0);
		assertEquals(parole.count(" "), 0);
		
		parole = new Parole(null);
		assertEquals(parole.count("CIAO"), 0);
		
		parole = new Parole("");
		assertEquals(parole.count("CIAO"), 0);
		
		parole = new Parole("	");
		assertEquals(parole.count("CIAO"), 0);
	}
	
	@Test
	void parolaMaxTest() {
		Parole parole = new Parole("Esempio.txt");
		assertTrue(parole.parolaMax().equalsIgnoreCase("è"));
		
		parole = new Parole(null);
		assertTrue(parole.parolaMax().equalsIgnoreCase(""));
		
		parole = new Parole("");
		assertTrue(parole.parolaMax().equalsIgnoreCase(""));
		
		parole = new Parole("  ");
		assertTrue(parole.parolaMax().equalsIgnoreCase(""));
	}

	@Test
	void parolaLenghtLessTest() {
		Parole parole = new Parole("Esempio.txt");
		String[] result1 = {"è","un", "file", "di","di","Ciao","ciao","ciao",
							"mi","e","sto","una","prova","sulle"};
		assertTrue(Arrays.asList(result1).containsAll(Arrays.asList(parole.parolaLenghtLess(6))));
	 	assertEquals(result1.length,parole.parolaLenghtLess(6).length);
	 	
	 	String[] result2 = {"Questo","è","un", "file", "di","esempio","di","Arrivederci","Ciao",
					"ciao","ciao","mi", "chiamo", "Facundo","e","sto","facendo","una",
					"prova","sulle","stream","stream","Facundo"};
	 	assertTrue(Arrays.asList(result2).containsAll(Arrays.asList(parole.parolaLenghtLess(15))));
	 	assertEquals(result2.length,parole.parolaLenghtLess(15).length);
	 	
	 	String[] result3 = {"è","un", "di","di","mi","e","sto","una"};
	 	assertTrue(Arrays.asList(result3).containsAll(Arrays.asList(parole.parolaLenghtLess(4))));
	 	assertEquals(result3.length,parole.parolaLenghtLess(4).length);
	 	
	 	assertArrayEquals(new String[0], parole.parolaLenghtLess(0));
	 	
	 	parole = new Parole(null);
	 	assertArrayEquals(new String[0], parole.parolaLenghtLess(100));
	 	
	 	parole = new Parole("");
	 	assertArrayEquals(new String[0], parole.parolaLenghtLess(100));
	 	
	 	parole = new Parole("  ");
	 	assertArrayEquals(new String[0], parole.parolaLenghtLess(100));
	 	
	}
}
