package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataanalysis.Dictionary;
import ADT.Word;

public class DictionaryTest {
	
	Dictionary testD;

	@Before
	public void setUp() throws Exception {
		testD = new Dictionary();
		testD.addword("A", 1, 2);
		testD.addword("B", 2, 4);
		testD.addword("C", 1, 6);
		testD.addword("D", 0, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpty() {
		Dictionary emptyDic = new Dictionary();
		assertTrue(emptyDic.isEmpty());
	}
	
	@Test
	public void testPosition() {
		Word tempWord = new Word("B", 2, 4);
		assertTrue(tempWord.getName().equals(testD.get(1).getName()));
	}

}
