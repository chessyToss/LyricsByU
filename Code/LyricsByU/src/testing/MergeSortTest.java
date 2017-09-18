package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ADT.Song;
import sort.MergeSort;

public class MergeSortTest {

	Song song1;
	Song song2;
	Song song3;
	
	ArrayList<Song> backwards;
	ArrayList<Song> empty;
	ArrayList<Song> duplicates;
	
	@Before
	public void setUp() throws Exception {
		song1 = new Song();
		song1.setName("song1");
		song1.setYear(2017);
		song1.setArtist("SongTest");
		song1.setGenre("1Test");
		song1.lyrics.add("Testing123");
		
		song2 = new Song();
		song2.setName("song2");
		song2.setYear(2017);
		song2.setArtist("SongTest");
		song2.setGenre("2Test");
		song2.lyrics.add("Testing123");
		
		song3 = new Song();
		song3.setName("song3");
		song3.setYear(2017);
		song3.setArtist("SongTest");
		song3.setGenre("3Test");
		song3.lyrics.add("Testing123");
		
		backwards = new ArrayList<Song>();
		backwards.add(song3);
		backwards.add(song2);
		backwards.add(song1);
		
		empty = new ArrayList<Song>();
		
		duplicates = new ArrayList<Song>();
		duplicates.add(song2);
		duplicates.add(song2);
		duplicates.add(song2);
		duplicates.add(song2);
		duplicates.add(song3);
		duplicates.add(song1);
		duplicates.add(song2);
		duplicates.add(song2);
		duplicates.add(song2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBackwards() {
		MergeSort.sort(backwards);
		assertTrue(backwards.get(0).equals(song1));
		assertTrue(backwards.get(1).equals(song2));
		assertTrue(backwards.get(2).equals(song3));
	}
	
	@Test
	public void testEmpty() {
		MergeSort.sort(empty);
		assertTrue(empty.isEmpty());
	}
	
	@Test
	public void testDuplicates() {
		MergeSort.sort(duplicates);
		assertTrue(duplicates.get(0).equals(song1));
		assertTrue(duplicates.get(2).equals(song2));
		assertTrue(duplicates.get(8).equals(song3));
	}

}
