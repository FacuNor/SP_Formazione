package rubricaEs5_6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubricaEs3_4.SchedaPersona;

class ArchivioCollectionTest {

	static IArchivio rubrica;
	static IScheda sp1;
	static IScheda sp2;
	static IScheda sa1;
	static IScheda sa2;
	static IScheda sa3;
	static IScheda snull;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sp1 = new rubricaEs5_6.SchedaPersona("MARIO ROSSI", " corso po 15 torino", "001");
		sp2 = new rubricaEs5_6.SchedaPersona("Sofia Bianchi", "via Roma 13 Catania", "002");
		sa1 = new SchedaAzienda("Azienda1", "Corso Bramante 6 Torino", "111", "Fax01");
		sa2 = new SchedaAzienda("Azienda2", "via da vinci 46 Torino", "222", "Fax02");
		sa3 = new SchedaAzienda("Azienda3", "via po 15 Torino", "333", "Fax03");
		snull = null;
		rubrica = new RubricaTelefonicaCollection();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void insertTest() {
		System.out.println(rubrica.toString());

		try {
			rubrica.insert(sp1);
			rubrica.insert(sp2);
			rubrica.insert(sa2);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

		// Provo ad inserire una Persona già presente
		try {
			rubrica.insert(sp2);
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		// Provo ad inserire una Azienda già presente
		try {
			rubrica.insert(sa2);
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}

		System.out.println(rubrica.toString());

		try {
			rubrica.insert(sa1);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

		// Trovando null non dovrebbe inserire nulla
		try {
			rubrica.insert(snull);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());
	}

	@Test
	void searchTest() {
		try {
			rubrica.insert(sp1);
			rubrica.insert(sp2);
			rubrica.insert(sa1);
			rubrica.insert(sa2);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}
		System.out.println("TEST");
		System.out.println(rubrica.toString());

		IScheda[] result1 = { sp1, sa1 };
		assertTrue(Arrays.asList(result1).containsAll(Arrays.asList(rubrica.search("corso"))));
		assertEquals(result1.length, rubrica.search("corso").length);

		IScheda[] result2 = { sp2, sa2 };
		assertTrue(Arrays.asList(result2).containsAll(Arrays.asList(rubrica.search("via "))));
		assertEquals(result2.length, rubrica.search("via ").length);

		IScheda[] result3 = { sa1, sa2 };
		assertTrue(Arrays.asList(result3).containsAll(Arrays.asList(rubrica.search("fax"))));
		assertEquals(result3.length, rubrica.search("fax").length);

		IScheda[] result4 = { sp1, sp2, sa1, sa2 };
		assertTrue(Arrays.asList(result4).containsAll(Arrays.asList(rubrica.search("0"))));
		assertEquals(result4.length, rubrica.search("0").length);

		String nullString = null;
		assertArrayEquals(rubrica.search(nullString), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(""), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(" "), new SchedaPersona[0]);
	}

	@Test
	void deleteTest() {
		// Provo a togliere un oggetto quando la rubrica è vuota
		try {
			rubrica.delete(sp1);
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}

		// Riempio la rubrica
		try {
			rubrica.insert(sp1);
			rubrica.insert(sp2);
			rubrica.insert(sa1);
			rubrica.insert(sa2);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

		// Tolgo un oggetto esistente
		try {
			rubrica.delete(sp2);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

		// Provo a togliere un oggetto che non esiste
		try {
			rubrica.delete(sp2);// Già rimosso
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		try {
			rubrica.delete(sa3);// Mai esistito
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		try {
			rubrica.delete(snull);// null
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();

			System.out.println(rubrica.toString());
		}
	}
}
