package search;

import java.util.ArrayList;
import java.util.Scanner;

import ADT.Word;
import Interface.UIinterface;
import dataanalysis.Dictionary;
import dataanalysis.ReadWord;

/**
 * The {@code GenreBinarySearch} class uses a modified binary search to find all songs that match a given genre
 * in a list of songs. The songs in the list must be sorted by genre.
 * 
 * @author Olivia Tinios 
 * Date Revised: 28/03/2017
 */
public class SearchKeyword {

	private static Word word;
	private static ArrayList<String> allLyrics;
	public static Dictionary ndic = ReadWord.readWord();	
	public static Dictionary gdic;

	/**
	 *  random return a line including the input word
	 * @param dic the specific dictionary
	 * @param keyword the word to be searched
	 * @return a line that consists the word
	 */
	public static String getOneLine(Dictionary dic,String keyword){
		keyword = ReadWord.stringfilter(keyword);
		allLyrics = new ArrayList<String>();
		int index = BinarySearch.binarySearch(dic, keyword);
		String match = "";
		for (int i = 0; i < dic.get(index).size(); i++) {
			String[] array;
			array = dic.get(index).get(i).split("-");
			int songindex = Integer.parseInt(array[0]);
			int sentenceindex = Integer.parseInt(array[1]);
			if (!ReadWord.song.get(songindex).lyrics.get(sentenceindex).equals(match)) {				
				match = ReadWord.song.get(songindex).lyrics.get(sentenceindex);
				allLyrics.add(match + "\n");
			}
		}
		int size = allLyrics.size();
		int num = (int) Math.floor(Math.random() * size);
		return allLyrics.get(num);
	}

	/**
	 *  random return a line including the input word
	 * @param keyword the word to be searched 
	 * @return a line that consists the word 
	 */
	public static String search(String keyword) {	
		return getOneLine(ndic,keyword);
	}
	
	/**
	 * random return a line with a specific genre including the input word
	 * @param keyword the word to be searched
	 * @param genre a specific genre
	 * @return a line that consists the word. The line is also from the genre input.
	 */
	public static String search(String keyword,String genre){
		gdic = ReadWord.readWord(genre);
		return getOneLine(gdic,keyword);
	}
	
	/**
	 * create an entire song
	 * @param keyword the word to be searched.
	 * @return a string of an entire song.
	 */
	public static String createSong(String keyword) {
		String song = "";
		String line = search(keyword);
		String firstline;
		for (int i = 0; i < 6; i++) {
				song += line;
				if (line.indexOf("-") > 0) {
					firstline = line.substring(0, line.indexOf("-"));
				} else {
					firstline = line;
				}
				int size = firstline.split(" ").length;

				line = search(firstline.split(" ")[(int) Math.floor(Math.random() * size)]);
			}
		line = search(keyword);
		
		String refrain = "";
		for (int i = 0; i < 2; i++) {
			refrain += line;
			if (line.indexOf("-") > 0) {
				firstline = line.substring(0, line.indexOf("-"));
			} else {
				firstline = line;
			}
			int size = firstline.split(" ").length;

			line = search(firstline.split(" ")[(int) Math.floor(Math.random() * size)]);
		}
		song += ("\n" + refrain + refrain + "\n");
		line = search(keyword);
		for (int i = 0; i < 6; i++) {
			song += line;
			if (line.indexOf("-") > 0) {
				firstline = line.substring(0, line.indexOf("-"));
			} else {
				firstline = line;
			}
			int size = firstline.split(" ").length;

			line = search(firstline.split(" ")[(int) Math.floor(Math.random() * size)]);
		}
		song += ("\n" + refrain + refrain + "\n");
		return song;
	}

}
