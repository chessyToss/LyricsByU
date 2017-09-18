package graph;
/**
 * The {@code Graph} class provides an implementation of undirected graph.
 * The graph class will be used to connect two lyric lines with same word.
 * 
 * @author Bowen Yuan
 * Date Revised: 01/04/2017
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import ADT.Song;
import IO.ReadFile;
import dataanalysis.Dictionary;
import dataanalysis.ReadWord;

public class Graph {
	private static ArrayList<Song> song = ReadFile.readCSV("data/lyrics_dataset.txt");
	private static HashMap<String, Integer> lyricLineId = new HashMap<String, Integer>();
	private static Dictionary dic;
	private int LyricId = 0; //Independent lyric id for each lyric line 
	private int V;  // number of vertex
	private int E=0;  // number of edge
	
	//adj TreeSet for each value in the map 
	private HashMap<Integer, TreeSet<Integer>> adj = new HashMap<Integer, TreeSet<Integer>>();;
	
	/**
	 * Construct the graph , give each lyric line with independent lyric id , 
	 * add edge to every pair of index with every word.
	 */
	public Graph(){
		for (int i = 0; i < song.size(); i++) {
			for (int j = 0; j < song.get(i).lyrics.size(); j++) {
				lyricLineId.put((i + "-" + j), LyricId);
				LyricId++;
			}
		}
		
		this.V = LyricId;
		for (int v=0;v<V;v++){
			adj.put(v, new TreeSet<Integer>());
		}
		
		dic = ReadWord.readwordForgraph();
		for (int i=0;i<dic.size();i++){
			for (int j=0;j<dic.get(i).size()-1;j++){
				addEdge(lyricLineId.get(dic.get(i).get(j)),lyricLineId.get(dic.get(i).get(j+1)));
				/*for (int k=j;k<dic.get(i).size()-1;k++){
					addEdge(lyricLineId.get(dic.get(i).get(j)),lyricLineId.get(dic.get(i).get(k+1)));
				}*/
			}	
		} 
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	/**
	 * Add edge when two lines have same word
	 * @param id of first line
	 * @param id of second line
	 */
	public void addEdge(int v, int w){
		adj.get(v).add(w);
		adj.get(w).add(v);
		E++;
	}
	
	/**
	 * the iterable of specific line
	 * @param id of one lyric line
	 * @return the iterable of specific line
	 */
	public Iterable<Integer> adj(int v){
		return adj.get(v);
	}
	
}

