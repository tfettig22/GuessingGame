package com.fettig.guessANumber;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/****

<b>Title:</b> GuessingGamePlayer.java<br>
<b>Project:</b> guessingGame<br>
<b>Description:</b>
	Player class for the Guessing Game, stores name, number of games played, and game scores as member variables
<br>
<b>Copyright:</b> Copyright (c) 2023<br>
<b>Company:</b> Silicon Mountain Technologies<br>
@author Tom Fettig
@version 1.0
@since Jan 10 2023
@updates:

****/

public class GuessingGamePlayer {
	
	private String name;
	private int numGamesPlayed;
	private Map<String, Integer> scores = new TreeMap<>();
	
	/**
	 * Setter method for the player's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for the player's name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Increments the number of games played by the player
	 */
	public void incrementNumGamesPlayed() {
		this.numGamesPlayed++;
	}
	
	/**
	 * Getter method for the number of games played
	 * @return
	 */
	public int getNumGamesPlayed() {
		return this.numGamesPlayed;
	}
	
	/**
	 * Adds a game score to the map of scores in the format of "Game n score = x"
	 * @param score an int value for the score that the player got for a certain game
	 */
	public void addToScores(int score) {
		this.scores.put("(" + this.numGamesPlayed + ")", score);
	}
	
	/**
	 * Gets the full map of scores for the player
	 * @return
	 */
	public Map<String, Integer> getScores() {
		return this.scores;
	}
	
	/**
	 * Calculates and returns the average score across every game played by the player
	 * @return the calculated average score in the form of a double value
	 */
	public double getAvgScore() {
		int total = 0;
		Object[] scoresArr = this.scores.values().toArray();
		for (int i = 0; i < scoresArr.length; i++) {
			total = total + (int) scoresArr[i];
		}
		return (double) total/this.numGamesPlayed;
	}
	
	/**
	 * Converts the values of each key in the scores map into an array, sorts the array, and returns the first element
	 * @return an Object value for the best score the player got
	 */
	public Object getBestScore() {
		Object[] allScores = this.scores.values().toArray();
		Arrays.sort(allScores);
		return allScores[0];
	}
	
	/**
	 * Converts the values of each key in the scores map into an array, sorts the array, and return the last element
	 * @return an Object value for the worst score the player got
	 */
	public Object getWorstScore() {
		Object[] allScores = this.scores.values().toArray();
		Arrays.sort(allScores);
		return allScores[allScores.length - 1];
	}
}