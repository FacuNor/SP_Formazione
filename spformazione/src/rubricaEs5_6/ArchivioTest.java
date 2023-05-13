package rubricaEs5_6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubricaEs3_4.SchedaPersona;

class ArchivioTest {

	static IArchivio rubrica;
	static IScheda sp1;
	static IScheda sp2;
	static IScheda sp3;
	static IScheda sp4;
	static IScheda sa1;
	static IScheda sa2;
	static IScheda sa3;
	static IScheda sa4;
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

		sp3 = new rubricaEs5_6.SchedaPersona("SOFIA BIANCHI", "VIA ROMA 13 CATANIA", "002");
		sp4 = new rubricaEs5_6.SchedaPersona("Marco Verdi", "piazza statuto 15 torino", "003");
		sa3 = new SchedaAzienda("azienda2", "via DA VINCI 46 Torino", "222", "Fax02");
		sa4 = new SchedaAzienda("Azienda3", "via po 15 Torino", "333", "Fax03");
		snull = null;

		rubrica = new rubricaEs5_6.RubricaTelefonica(4);
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

		// Provo ad inserire una Persona già presente -> CATCH
		try {
			rubrica.insert(sp3);
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		// Provo ad inserire una Azienda già presente -> CATCH
		try {
			rubrica.insert(sa3);
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

		// Provo ad inserire una persona con la rubrica piena -> CATCH
		try {
			rubrica.insert(sp4);
			fail();
		} catch (ArchiveException e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		}
		// Provo ad inserire un'azienda con la rubrica piena -> CATCH
		try {
			rubrica.insert(sa4);
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
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
		IScheda[] result1 = { sp1, sa1 };
		assertArrayEquals(rubrica.search("corso"), result1);

		IScheda[] result2 = { sp2, sa2 };
		assertArrayEquals(rubrica.search("via "), result2);

		IScheda[] result3 = { sa1, sa2 };
		assertArrayEquals(rubrica.search("fax"), result3);

		IScheda[] result4 = { sp1, sp2, sa1, sa2 };
		assertArrayEquals(rubrica.search("0"), result4);

		String nullString = null;
		assertArrayEquals(rubrica.search(nullString), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(""), new SchedaPersona[0]);
		assertArrayEquals(rubrica.search(" "), new SchedaPersona[0]);
	}

	@Test
	void deleteTest() {
		try {
			// Provo a togliere un oggetto quando la rubrica è vuota -> CATCH
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
		}catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}
		
		System.out.println(rubrica.toString());

		// Tolgo un oggetto esistente 
		try {
			rubrica.delete(sp3);
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

		// Provo a togliere un oggetto che non esiste
		try {
			rubrica.delete(sp3);// Già rimosso -> CATCH
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		try {
			rubrica.delete(sa4);// Mai esistito -> CATCH
			fail();
		} catch (ArchiveException e) {
			System.err.println(e.toString());
		}
		try {
			rubrica.delete(snull);// null
		} catch (ArchiveException e) {
			System.err.println(e.toString());
			fail();
		}

		System.out.println(rubrica.toString());

	}

}
