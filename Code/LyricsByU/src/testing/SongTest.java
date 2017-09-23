package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ADT.Song;

public class SongTest {
	
	Song song1;
	Song song2;

	@Before
	public void setUp() throws Exception {
		song1 = new Song();
		song1.setName("song1");
		song1.setYear(2017);
		song1.setArtist("SongTest");
		song1.setGenre("Test");
		song1.lyrics.add("Testing123");
		
		song2 = new Song();
		song2.setName("song1");
		song2.setYear(2017);
		song2.setArtist("SongTest");
		song2.setGenre("Test");
		song2.lyrics.add("Testing123");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSameIndex() {
		song1.setIndex(1);
		song2.setIndex(1);
		assertTrue(song1.sameIndex(song2));
	}
	
	@Test
	public void testSameIndexCompare() {
		song1.setIndex(0);
		song2.setIndex(0);
		assertEquals(0, song1.compareTo(song2));
	}
	
	@Test
	public void testGreaterIndex() {
		song1.setIndex(3);
		song2.setIndex(2);
		assertEquals(1, song1.compareTo(song2));
	}
	
	@Test
	public void testGreaterNegIndex() {
		song1.setIndex(-3);
		song2.setIndex(-50);
		assertEquals(1, song1.compareTo(song2));
	}
	
	@Test
	public void testLesserIndex() {
		song1.setIndex(0);
		song2.setIndex(3);
		assertEquals(-1, song1.compareTo(song2));
	}
	
	@Test
	public void testLesserNegIndex() {
		song1.setIndex(-99);
		song2.setIndex(2);
		assertEquals(-1, song1.compareTo(song2));
	}

}
