package dataanalysis;

import java.util.ArrayList;

import ADT.Word;
import search.BinarySearch;

/**
 * 
 * @author Micho (Tongfei Wang)
 *		Description:  An ADT that represents a Dictionary that consists of Words. 
 */
public class Dictionary extends ArrayList<Word> {

	/**
	 * add the word into dictionary if the word did not exist in the dictionary. 
	 * If the word exists, add the song index and the sentence index to that word.
	 * @param word the word to be added
	 * @param songindex the song index of the word
	 * @param sentenceindex the sentence index of the word
	 */
	public void addword(String word, int songindex, int sentenceindex) {
		if (this.size() == 0){
			this.add(new Word(word, songindex, sentenceindex));
		}
		else {
			int index = BinarySearch.binarySearch(this, word);
			if (index >= 0){
				this.get(index).add(String.valueOf(songindex) + "-" + String.valueOf(sentenceindex));
			}	
			else {
				this.add((index * -1 - 1), new Word(word, songindex, sentenceindex));
			}

		}
	}

}
