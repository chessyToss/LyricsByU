/**
 * By testing this, will indirectly test ReadWord
 */
package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dataanalysis.Dictionary;
import dataanalysis.ReadWord;
import search.SearchKeyword;

public class SearchKeywordReadWordTest {
	
	Dictionary allSongsTest;
	Dictionary genreTest;
	String line; 

	
	@Before
	public void setUp() throws Exception {
		allSongsTest = ReadWord.readWord();
		line = "Too many marksmen on the knolls,\n";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLineInDic() {
		assertTrue(SearchKeyword.getOneLine(allSongsTest, "knolls").equals(line));
		assertTrue(SearchKeyword.search("knolls").equals(line));
	}
	
	@Test
	public void testLineInRock() {
		genreTest = ReadWord.readWord("rock");
		assertTrue(SearchKeyword.getOneLine(genreTest, "knolls").equals(line));
		assertTrue(SearchKeyword.search("knolls", "rock").equals(line));
	}
	
	@Test
	public void testLineInPop() {
		try{
			assertFalse(SearchKeyword.search("knolls","pop").equals(line));
		} catch (Exception notInList) {
			fail("Does not handle word not in genre - will have to alter or watch for exception when calling");
			//Decided to handle this exception with the UI interface to more easily show the user the issue
		}
	}
	
	@Test
	public void testSongContainsWord() {
		String song = SearchKeyword.createSong("knolls");
		assertTrue(song.substring(0, line.length()).equals(line));
	}
	
	@Test
	public void testSongContainsUpperWord() {
		String song = SearchKeyword.createSong("KNOLLS");
		assertTrue(song.substring(0, line.length()).equals(line));
		//handles words when not capitalized properly
	}

	@Test
	public void testReadWordFilter() {
		assertTrue(ReadWord.stringfilter("h;el%lo!").equals("hello"));
	}
	
}
