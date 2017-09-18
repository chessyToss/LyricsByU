package dataanalysis;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import ADT.Song;
import IO.ReadFile;
import search.GenreBinarySearch;
import sort.MergeSort;

/**
 * 
 * @author Bowen Yuan, Micho (Tongfei Wang)
 *		Description:  Put all the words into three different Dictionaries
 */
public class ReadWord {
	public static ArrayList<Song> song = ReadFile.readCSV("data/lyrics_dataset.txt");
	private static Dictionary allSongDic;//sorted all songs
	private static Dictionary genreSongDic;//sorted songs with specific genre
	private static Dictionary dic3; //all songs
	
	/**
	 * sort the songs first , and import them to dictionary
	 * @return dictionary whose songs are already sorted
	 */
	public static Dictionary readWord() {
		allSongDic = new Dictionary();
		MergeSort.sort(song);
		for(int i = 0; i< song.size();i++){
			for(int j = 0; j < song.get(i).lyrics.size(); j++){
				String[] array ;
				array = stringfilter(song.get(i).lyrics.get(j)).split(" ");
				for(int k = 0; k < array.length; k++){
					allSongDic.addword(array[k],i,j);
				}
			}
		}
		
		return allSongDic;
	}
	
	/**
	 * sort the songs first, and search the genre , import the songs only with specific genre to the dictionary
	 * @param genre
	 * @return the dictionary with specific genre
	 */
	public static Dictionary readWord(String genre) {
		genreSongDic = new Dictionary();
		MergeSort.sort(song);
		int[] arr = GenreBinarySearch.search(song,genre);
		for(int i = arr[0]; i< arr[1];i++){
			for(int j = 0; j < song.get(i).lyrics.size(); j++){
				String[] array ;
				array = stringfilter(song.get(i).lyrics.get(j)).split(" ");
				for(int k = 0; k < array.length; k++){
					genreSongDic.addword(array[k],i,j);
				}
			}
		}		
		return genreSongDic;
	}
	
	/**
	 * import all the songs to dictionary
	 * @return dictionary with all the songs
	 */
	public static Dictionary readwordForgraph() {
		dic3 = new Dictionary();
		for(int i = 0; i< song.size();i++){
			for(int j = 0; j < song.get(i).lyrics.size(); j++){
				String[] array ;
				array = stringfilter(song.get(i).lyrics.get(j)).split(" ");
				for(int k = 0; k < array.length; k++){
					dic3.addword(array[k],i,j);
				}
			}
		}
		
		return dic3;
	}
	
	/**
	 * filter all the meaningless characters
	 * @param str
	 * @return the input string without meaningless characters
	 * @throws PatternSyntaxException
	 */
	public static String stringfilter(String str) throws PatternSyntaxException{
		String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\],.<>/?~锛丂#锟�%鈥︹��&*锛堬級鈥斺��?+|{}銆愩�戔�橈紱锛氣�濃�溾�欍�傦紝銆侊紵]";
		Pattern p = Pattern.compile(regEx);
		//search all the special characters the string has
		Matcher m = p.matcher(str);
		//replace them with ""
		return m.replaceAll("").trim();
	}

}
