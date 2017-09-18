package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ADT.Word;

public class WordTest {

	Word word1;
	Word word2;
	Word word3;
	
	@Before
	public void setUp() throws Exception {
		word1 = new Word("A", 1, 1);
		word2 = new Word("b", 0, 2);
		word3 = new Word("a", 1, 1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSameWord() {
		assertTrue(word1.equalString(word3.getName()));
		assertEquals(0, word1.compareString(word3.getName()));
	}
	
	@Test
	public void testOtherWord() {
		assertFalse(word1.equalString(word2.getName()));
		assertEquals(-1, word1.compareString(word2.getName()));
	}

	/* indices functionality not implemented in word
	@Test
	public void testSameIndex() {
		fail("Not yet implemented");
	}
	*/
}
