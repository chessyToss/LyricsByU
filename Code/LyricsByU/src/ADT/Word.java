package ADT;
import java.util.ArrayList;

/**
 * 
 * @author Micho (Tongfei Wang)
 *		Description:  An ADT that represents Words which consists of the index of the words.
 *			The index of the word would have a song index and a sentence index
 *			The name of the word would be the String of the word(The word itself).
 */
public class Word extends ArrayList<String> {
	private String name;
	
	/**
	 * construct a word with the String of the word and both the indexes
	 * @param name the string of the word
	 * @param songindex the song index that the word belongs to
	 * @param sentenceindex the line index that the word belongs to
	 */
	public Word(String name, int songindex, int sentenceindex){
		this.name = name;
		this.add(String.valueOf(songindex) + "-" + String.valueOf(sentenceindex));
	}

	/**
	 * get the string of the word
	 * @return the string of the word
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 *  compare two words
	 * @param other the other word
	 * @return positive if the first word bigger, negative if it is smaller 0 if they are equal.
	 */
	//@Override
	public int compareString(String other) {
		return (this.name.compareToIgnoreCase(other));
	}
	
	/**
	 * check if two words are the same
	 * @param other the other word
	 * @return true if they are same
	 */
	public boolean equalString(String other) {
		return (this.name.equalsIgnoreCase(other));
	}
}
