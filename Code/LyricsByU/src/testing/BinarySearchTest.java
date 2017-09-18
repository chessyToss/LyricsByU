package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataanalysis.Dictionary;
import search.BinarySearch;

public class BinarySearchTest {
	Dictionary testD;

	@Before
	public void setUp() throws Exception {
		testD = new Dictionary();
		testD.addword("A", 1, 2);
		testD.addword("B", 2, 4);
		testD.addword("L", 1, 6);
		testD.addword("P", 0, 4);
		testD.addword("Z", 6, 6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNormal() {
		assertEquals(0, BinarySearch.binarySearch(testD, "A"));
		assertEquals(2, BinarySearch.binarySearch(testD, "L"));
		assertEquals(4, BinarySearch.binarySearch(testD, "Z"));
	}
	
	@Test
	public void testNotInDic() {
		assertTrue(BinarySearch.binarySearch(testD, "C") < 0);
	}
	
	@Test
	public void testEmpty() {
		Dictionary empty = new Dictionary();
		assertEquals(-1, BinarySearch.binarySearch(empty, "A"));
	}

}
