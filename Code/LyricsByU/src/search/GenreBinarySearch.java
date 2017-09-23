package search;

import java.util.ArrayList;

import ADT.Song;
/**
 * The {@code GenreBinarySearch} class uses a modified binary search to find all songs that match a given genre
 * in a list of songs. The songs in the list must be sorted by genre.
 * 
 * @author Olivia Tinios 
 * Date Revised: 28/03/2017
 */
public class GenreBinarySearch {
	
	/**
	 * Modified binary search that searches for all matching entries.
	 * @param x - list of songs, sorted by genre.
	 * @param s - the genre that needs to be searched for.
	 * @return array containing the upper and lower index of all matching entries.
	 */
	public static int[] search(ArrayList<Song> x, String s) {
		// Store low index and high index in array.
		int[] arr = new int[2];
		arr[0] = lowIndex(x, s, 0, x.size()-1);
		arr[1] = highIndex(x, s, 0, x.size()-1);
		return arr;
	}

	/******************************************************************************
	 * Helper function that finds the matching entry with the lowest index.
	 ******************************************************************************/
	private static int lowIndex(ArrayList<Song> x, String s, int lo, int hi) {
		
		if (lo > hi) return lo;
		int mid = lo + ((hi - lo)/2);
		
		// Compare genres, keep going left if equal value is found.
		if ((x.get(mid).getGenre()).compareToIgnoreCase(s) >= 0) 
			return lowIndex(x, s, lo, mid-1);
		else
			return lowIndex(x, s, mid+1, hi);
	}
	
	/******************************************************************************
	 * Helper function that finds the matching entry with the highest index.
	 ******************************************************************************/
	private static int highIndex(ArrayList<Song> x, String s, int lo, int hi) {

		if (lo > hi) return lo-1;
		int mid = lo + ((hi - lo)/2);
		
		// Compare genres, keep going right if equal value is found.
		if ((x.get(mid).getGenre()).compareToIgnoreCase(s) > 0) 
			return highIndex(x, s, lo, mid-1);
		else
			return highIndex(x, s, mid+1, hi);
	}

	/*public static void main(String[] args) {
		ArrayList<Song> songList = IOtest.readCSV("src/iotest.txt");
		MergeSort.sort(songList);
		int[] arr = search(songList, "Pop");
		int l = arr[0];
		int h = arr[1];
		System.out.println(l + "-" + h);
		System.out.println(songList.get(l).getGenre());
		System.out.println(songList.get(l-1).getGenre());
		System.out.println(songList.get(h).getGenre());
		System.out.println(songList.get(h+1).getGenre());
	}*/
}