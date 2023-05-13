package demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckFilesNamesTest {

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
	/**
	 * Test che controlla i risultati se l'inpunt inserito è corretto sintassicamente 
	 * (Alcuni OK altri da scartare)
	 */
	void testInputOK() {
		String input = "1988-08-29 956 system.zip " + "1995-10-12 245760 old-photos.tgz "
				+ "1989-11-05 245761 file2.rar " + "1996-12-01 845 very-long-filename.rar "
				+ "1988-11-05 400 file1.zip ";

		CheckFilesNames c = new CheckFilesNames(input);

		assertEquals(c.checkFiles(), "3");

		assertEquals(c.filesDiscardedCount(), 2);

		CheckFilesNames.Files[] testFiles = { c.new Files("system.zip", 956, LocalDate.of(1988, 8, 29)),
											  c.new Files("old-photos.tgz", 245760, LocalDate.of(1995, 10, 12)),
											  c.new Files("file1.zip", 400, LocalDate.of(1988, 11, 05)) };

		CheckFilesNames.Files[] result = c.fileGood();

		for (int i = 0; i < result.length; i++) {
			assertTrue(testFiles[i].equals(result[i]));
		}

	}

	@Test
	/**
	 * Test che controlla i risultati se l'input inserito è sintassicamente NON corretto
	 */
	void testInputNotOK() {
		// TEST su stringa NULL
		CheckFilesNames c = new CheckFilesNames(null);
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

		// TEST su stringa vuota
		c = new CheckFilesNames("");
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

		// TEST su striga errata al primo file (nome)
		String input = "1988-08-29 956 system.txt ";
		c = new CheckFilesNames(input);
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

		// TEST su striga errata al primo file (giorno)
		input = "1988-08-33 956 system.rar ";
		c = new CheckFilesNames(input);
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

		// TEST su striga errata al primo file (mese)
		input = "1988-15-25 956 system.rar ";
		c = new CheckFilesNames(input);
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

		// TEST su striga errata al primo file (Errore formato data)
		input = "20t5-08-25 956 system.rar ";
		c = new CheckFilesNames(input);
		assertEquals(c.checkFiles(), "INVALID INPUT");
		assertEquals(c.filesDiscardedCount(), 0);
		assertEquals(c.fileGood().length, 0);

	}

	@Test
	/**
	 * Test che controlla i risultati se l'input inserito è inizalmente 
	 * sintassicamente corretto per poi avere un input NON corretto
	 */
	void testInputAlmostOk() {
		String input = "1988-08-29 956 system.zip " + "1995-10-12 245760 old-photos.zip "
				+ "1989-11-05 245761 file.rar " + "1996-12-01 845 very-long-filename.rar "
				+ "1988-11-05 400 file1.txt ";

		CheckFilesNames c = new CheckFilesNames(input);
		assertEquals(c.checkFiles(), "INVALID INPUT");

		assertEquals(c.filesDiscardedCount(), 2);

		CheckFilesNames.Files[] testFiles = { c.new Files("system.zip", 956, LocalDate.of(1988, 8, 29)),
										      c.new Files("old-photos.zip", 245760, LocalDate.of(1995, 10, 12)) };

		CheckFilesNames.Files[] result = c.fileGood();

		for (int i = 0; i < result.length; i++) {
			assertTrue(testFiles[i].equals(result[i]));
		}
	}

	@Test
	/**
	 * Test che controlla i risultati se l'inpunt inserito è corretto sintassicamente 
	 * ma con tutti i files da scartare
	 */
	void testDiscardAllInput() {
		String input = "1988-08-29 956284 system.zip " + "1995-11-12 245760 old-photos.tgz "
				+ "1989-11-05 245761 file2.rar " + "1996-12-01 845 very-long-filename.rar "
				+ "1998-11-05 400538 file1.zip ";

		CheckFilesNames c = new CheckFilesNames(input);

		assertEquals(c.checkFiles(), "NO FILES");

		assertEquals(c.filesDiscardedCount(), 5);
		
		assertEquals(c.fileGood().length, 0);
	}

}
