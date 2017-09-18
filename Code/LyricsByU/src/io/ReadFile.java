package IO;
/**
 * Data input from the csv file to the song ADT
 * @author Bowen Yuan, Evan Ansell
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import ADT.Song;

public class ReadFile {
	
	/**
	 * check whether the input string is number or not 
	 * @param str
	 * @return whether the input string is number or not 
	 */
	private static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();     
	}  
	
	/**
	 * reads the csv. Detects when a song is read and creates a new Song data type with the line's information. 
	 * Adds lyrics to that Song until it finds the next song and then adds the completed song to the ArrayList.
	 * @return the ArrayList of songs
	 */
	public static ArrayList<Song> readCSV(String dataset){
		BufferedReader reader = null;
		String line = "";
		String arr[] = null;
		ArrayList<Song> songlist = new ArrayList<Song>();
		try {
			reader = new BufferedReader(new FileReader(dataset)); //sample of dataset used since full dataset causes out of memory error 
			reader.readLine();
			Song song = new Song();
			while((line=reader.readLine())!=null){
				if (line.split(",").length>=6&&isNumeric(line.split(",")[0])&&line.split("\"").length==2){
					arr = line.split("\"");
					songlist.add(song);
					song = new Song();
					song.setIndex(Integer.parseInt(arr[0].split(",")[0]));
					song.setName(arr[0].split(",")[1]);
					song.setYear(Integer.parseInt(arr[0].split(",")[2]));
					song.setArtist(arr[0].split(",")[3]);
					song.setGenre(arr[0].split(",")[4]);
					song.lyrics.add(arr[1]);
					continue;
				}
				song.lyrics.add(line);
			}
			songlist.remove(0); //removes the first line of csv describing how the csv is arranged
			//System.out.println("Input completed!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return songlist;	
	}
	
}
