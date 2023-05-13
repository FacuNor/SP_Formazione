package rubricaEs3_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SchedaPersonaTest {
	static SchedaPersona sp1;
	static SchedaPersona sp2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sp1 = new SchedaPersona();
		sp1.setNome("Mario Rossi");
		sp1.setIndirizzo("Via Po 15 Torino ");
		sp1.setNumero("001");
		sp2 = new SchedaPersona("Sofia Bianchi", "via Roma 13 Catania", "002");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void equalsTest() {
		SchedaPersona test1 = new SchedaPersona("MARIO ROSSI", " via po 15 torino", "001");
		assertTrue(sp1.equals(test1));

		SchedaPersona test2 = new SchedaPersona();
		assertFalse(sp2.equals(test2));
		test2.setNome("sofia bianchi ");
		test2.setIndirizzo("via Roma 13 Catania");
		test2.setNumero("002");
		assertTrue(sp2.equals(test2));
	}

	@Test
	void containsTest() {
		assertTrue(sp1.contains("mario"));
		assertTrue(sp1.contains("po"));
		assertTrue(sp1.contains("001  "));
		assertFalse(sp1.contains("ciao"));

		String nullString = null;
		assertFalse(sp1.contains(nullString));
		assertFalse(sp1.contains(""));
		assertFalse(sp1.contains(nullString));
		assertFalse(sp1.contains("	"));
	}

}
