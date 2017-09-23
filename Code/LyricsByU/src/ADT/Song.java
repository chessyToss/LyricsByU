package ADT;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Micho (Tongfei Wang)
 *		Description:  An ADT that represents Songs.
 */
public class Song implements Comparable<Song> {
	private String name;	
	private String genre;
	public ArrayList<String> lyrics = new ArrayList<String>();	
	private String artist;
	private int year;
	private int index;

	/**
	 * return the name of the song
	 * @return the name of the song
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the name of the song
	 * @param name the name of the song
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the genre of the song
	 * @return the genre of the song
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * set the genre of the song
	 * @param genre the genre of the song
	 */
	public void setGerne(String genre) {
		this.genre = genre;
	}

	/**
	 * set the artist of the song
	 * @param artist the artist of the song
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * return the artist of the song
	 * @return the artist of the song
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * set the song index
	 * @param i the index of the song
	 */
	public void setIndex(int i) {
		this.index = i;
	}

	/**
	 * return the index of the song
	 * @return the index of the song
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * set the year of the song created
	 * @param y the year
	 */
	public void setYear(int y) {
		this.year = y;
	}
	
	/**
	 * return the year of the song
	 * @return the year of the song
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * return the lyrics of the song
	 * @return the lyrics
	 */
	public List<String> getLyrics() {
		return lyrics;
	}

	/**
	 * set the genre of the song
	 * @param genre the genre of the song
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int compareTo(Song other) {
		if (this.index > other.index)
			return 1;
		else if (this.index < other.index)
			return -1;
		else
			return 0;
	}
	
	public boolean sameIndex(Song other) {
		if (this.index == other.index)
			return true;
		return false;
	}
	
	/**
	 * return the infomation of the song
	 */
	public String toString(){
		return "  ---  Song:"+this.name+" Artist:"+this.artist+" Year:"+this.year+" Genre: "+this.genre;
	}
	
}
