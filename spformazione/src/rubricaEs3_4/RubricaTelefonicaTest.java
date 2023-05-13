package rubricaEs3_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RubricaTelefonicaTest {

	static IRubrica rubrica;
	static SchedaPersona sp1;
	static SchedaPersona sp2;
	static SchedaPersona sp3;
	static SchedaPersona sp4;
	static SchedaPersona sp5;
	static SchedaPersona sp6;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sp1 = new SchedaPersona("MARIO ROSSI", " via po 15 torino", "001");
		sp2 = new SchedaPersona("Sofia Bianchi", "via Roma 13 Catania", "002");
		sp3 = new SchedaPersona("Facundo Acosta", "Corso Bramante 6 Torino", "010");

		sp4 = new SchedaPersona("SOFIA BIANCHI", "VIA ROMA 13 CATANIA", "002");
		sp5 = new SchedaPersona("Marco Verdi", "piazza statuto 15 torino", "003");
		sp6 = null;

		rubrica = new RubricaTelefonica(3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void insertTest() {
		assertTrue(rubrica.insert(sp1));
		assertTrue(rubrica.insert(sp2));
		// sp4 non dovrebbe essere inserito perché uguale ad sp2
		assertFalse(rubrica.insert(sp4));

		assertTrue(rubrica.insert(sp3));
		// Non dovrebbe essere inserito perché sforiamo la grandezza dell'array
		assertFalse(rubrica.insert(sp5));
		// Trovando null non dovrebbe inserire nulla
		assertFalse(rubrica.insert(sp6));
	}

	@Test
	void searchTest() {

		rubrica.insert(sp1);
		rubrica.insert(sp2);
		rubrica.insert(sp3);

		SchedaPersona[] resultSearch1 = { sp1, sp2 };
		assertArrayEquals(rubrica.search("via "), resultSearch1);

		SchedaPersona[] resultSearch2 = { sp1, sp3 };
		assertArrayEquals(rubrica.search("torino"), resultSearch2);

		String nullString = null;
		assertArrayEquals(rubrica.search(nullString), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(""), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(" "), new SchedaPersona[0]);
	}

	@Test
	void deleteTest() {
		// Provo a togliere un oggetto quando la rubrica è vuota
		assertFalse(rubrica.delete(sp6));
		System.out.println(rubrica.toString());

		// Riempio la rubrica
		rubrica.insert(sp1);
		rubrica.insert(sp2);
		rubrica.insert(sp3);

		System.out.println(rubrica.toString());
		// Tolgo un oggetto esistente
		assertTrue(rubrica.delete(sp4));
		System.out.println(rubrica.toString());
		// Provo a togliere un oggetto che non esiste
		assertFalse(rubrica.delete(sp4));// Già rimosso
		assertFalse(rubrica.delete(sp5));// Mai esistito
		assertFalse(rubrica.delete(sp6));// null
		System.out.println(rubrica.toString());

	}

}
