package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import dataanalysis.Dictionary;

/**
 * 
 * @author Tim Zhang, Micho (Tongfei Wang)
 *		Description:  search the location of a word in a dictionary
 */
public class BinarySearch {
	
	/**
	 * Searches an array of words for a given value using a recursive binary
	 * search. Returns the index that contains the value or the (nearest index * -1) if the value is
	 * not found.
	 * 
	 * @param words the dictionary to search in
	 * @param value the word to be searched
	 * @return the index that contains the word or the (nearest index * -1) if the value is
	 * not found.
	 */
	public static int binarySearch(Dictionary dictionary, String value) {
		return binarySearch(dictionary, value, 0, dictionary.size() - 1);
	}
	
	
	//recursive binarySearch method used from initial call
	private static int binarySearch(Dictionary words, String value, int min, int max) {
		if (min > max) {
			if(min==0)return -1;
			return (-1 *min-1);
		}
		int mid = (max + min) / 2;
		if (words.get(mid).equalString(value)) {
			return mid;
		} else if (words.get(mid).compareString(value) > 0) {
			return binarySearch(words, value, min, mid - 1);
		} else {
			return binarySearch(words, value, mid + 1, max);
		}
	}
}
