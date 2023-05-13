package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {

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

	@SuppressWarnings("deprecation")
	@Test
	void testEta() {
		Persona p = new Persona("Facundo", "Acosta", new Date(95, 9, 1), 27);
		assertTrue(p.getEta() > 20);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testCognome() {
		Persona p = new Persona("Facundo", "Acosta", new Date(95, 9, 1), 27);
		String test = p.getCognome().toUpperCase();
		
		assertEquals(p.getCognome(), test);
	}

}
