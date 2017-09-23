package sort;

import java.util.ArrayList;
import java.util.List;

import ADT.Song;

/**
 * The {@code MergeSort} class provides an implementation of merge sort.
 * The sort method will be used to sort a list of songs by genre(in alphabetical order).
 * 
 * @author Olivia Tinios 
 * Date Revised: 28/03/2017
 */
public class MergeSort {
	
	// auxiliary array (elements are copied into this array during merge)
	private static List<Song> aux;
	
	/**
	 * Merge Sort for a list of songs.
	 * @param x - the input array containing a list of songs to be sorted.
	 */
	public static void sort(ArrayList<Song> x) {
		aux = new ArrayList<Song>();
		for (int i = 0; i < x.size(); i++) 
			aux.add(null);
		sort(x, 0, x.size()-1);
	}
	
	/******************************************************************************
	 * Helper function that sorts sub arrays using recursive calls and merges the
	 * sorted sub arrays.
	 ******************************************************************************/
	private static void sort(ArrayList<Song> x, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(x, lo, mid);
		sort(x, mid+1, hi);
		merge(x, lo, mid, hi);
	}
	
	/******************************************************************************
	 * Helper function that performs an abstract in-place merge.
	 ******************************************************************************/
	private static void merge (ArrayList<Song> x, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
		
		for (int k = lo; k <= hi; k++) {
			aux.set(k, x.get(k));
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) x.set(k, aux.get(j++));
			else if (j > hi) x.set(k, aux.get(i++));
			else if (less(aux.get(j), aux.get(i))) x.set(k, aux.get(j++));
			else x.set(k, aux.get(i++));
		}
	}
	
	/******************************************************************************
	 * Helper function that compares two Song objects based on their genre.
	 ******************************************************************************/
	private static boolean less (Song v, Song w ) {
		return (v.getGenre()).compareTo(w.getGenre()) < 0; 
	}
	
}


