package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EserciziTest {

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
	void testIsPalindroma() {
		String string = "Anna";
		assertTrue(Esercizi.isPalindroma(string));
	}

	@Test
	void testMySort() {
		int[] x = { 5, 4, 7, 8, 3, 1, 2, 9, 6 };
		int[] result = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Esercizi.mySort(x);

		assertArrayEquals(x, result);
	}

	@Test
	void testMyBinarySearch() {
		int[] x = { 5, 4, 7, 8, 3, 1, 2, 9, 6 };
		int[] z = {};
		Esercizi.mySort(x);
		assertTrue(Esercizi.myBinarySearch(x, 5));
		assertFalse(Esercizi.myBinarySearch(z, 4));
		assertFalse(Esercizi.myBinarySearch(null, 0));
	}

	@Test
	void testLeggiStringa() {
		String s = "12 Ciao 24,5 14 Facundo 23,4 10 sole 98,4";
		assertTrue(Esercizi.leggoStringa(s));
		s = null;
		assertFalse(Esercizi.leggoStringa(s));
		s = "";
		assertFalse(Esercizi.leggoStringa(s));
		s = "  ";
		assertFalse(Esercizi.leggoStringa(s));
	}

	@Test
	void testLeggiMatrice() {
		int[][] matrice = { { 34, 5, 6, 15, 9 }, 
							{ 3, 20, 7, 64, 41 }, 
							{ 1, 79, 8, 90, 88 }, 
							{ 18, 27, 43, 62, 100 },
							{ 5, 77, 34, 59, 12 } };
		Esercizi e = new Esercizi();
		int[][] result = e.leggiMatrice();
		for (int i = 0; i < 5; i++) {
			assertArrayEquals(matrice[i], result[i]);
		}
	}

}
