package com.fettig.guessANumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/****

<b>Title:</b> GuessingGame.java<br>
<b>Project:</b> guessingGame<br>
<b>Description:</b>
	Guessing Game class that instantiates a new game and allows the player to play the guessing game via the console
	Uses a separate player class that stores the player's name
	Uses a separate language pack that allows the user to play the game in either English or Spanish
	The game prompts the user to choose a language, enter their name, and choose a maximum number for the range of possible numbers to guess
	The user will continue to guess numbers until the winning number is guessed, at which point the game will display a win message and the user's statistics for that game
	The user will decide if they want to keep playing or not
	If yes, game restarts at the point where user picks a number range
	If no, statistics will be shown for the player's game session and the game ends
<br>
<b>Copyright:</b> Copyright (c) 2023<br>
<b>Company:</b> Silicon Mountain Technologies<br>
@author Tom Fettig
@version 1.0
@since Jan 10 2023
@updates:

****/

public class GuessingGame {
	
	private int winningNumber;
	private int numGuesses;
	private boolean correct = false;
	private boolean continuePlaying = true;
	private List<Integer> playerGuesses = new ArrayList<>();
	Random r = new Random();
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Instantiates a new game, player, and language pack. Language pack is set by user input using scanner. Once language has been set, user is prompted to enter name, and then the game starts
	 * @param args
	 */
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		GuessingGamePlayer player = new GuessingGamePlayer();
		LanguagePack language = new LanguagePack(game.setLanguage());
		
		game.selectPlayer(player, language);
		game.playGame(player, language);
	}
	
	/**
	 * Prompts the user to set the language to either english or spanish
	 * @return
	 */
	public String setLanguage() {
		System.out.println("English or Spanish?");
		return scanner.next();
	}
	
	/**
	 * While the user wants to continue playing: Initializes the game by prompting the user to set the range of possible numbers
	 * Sets the winning number
	 * Prompts user to input a guess
	 * Shows the statistics for the current game
	 * Increments the number of games the user has played
	 * Stores player statistics
	 * Prompts user to play again or quit
	 * @param player the current instance of player
	 * @param language the current language pack being used
	 */
	public void playGame(GuessingGamePlayer player, LanguagePack language) {
		while (this.continuePlaying) {
			language.displayNumberPrompt();
			this.winningNumber = r.nextInt(scanner.nextInt());
			acceptAGuess(language);
			showGameStats(language);
			player.incrementNumGamesPlayed();
			saveStatistics(player);
			askToContinuePlaying(player, language);
		}
	}
	
	/**
	 * Prompts the user to input a name and assigns it to the current player
	 * @param player the current instance of player
	 * @param language the current language pack being used
	 */
	public void selectPlayer(GuessingGamePlayer player, LanguagePack language) {
		language.displayWelcome();
		player.setName(scanner.next());
	}
	
	/**
	 * While the boolean correct is false: Prompts the user to input a guess
	 * Records the guess
	 * Determines if the guess is right or wrong
	 * Gives feedback based on the accuracy of the guess
	 * @param language the current language pack being used
	 */
	public void acceptAGuess(LanguagePack language) {
		while (!this.correct) {
			language.displayGuessPrompt();
			int guess = scanner.nextInt();
			recordGuess(guess);
			determineIfGuessIsCorrect(guess);
			giveFeedback(guess, language);
		}
	}
	
	/**
	 * Increments the number of guesses the player has made
	 * Adds the guess to the current list of guesses
	 * @param guess the most recent guess the player has made
	 */
	public void recordGuess(int guess) {
		this.numGuesses++;
		this.playerGuesses.add(guess);
	}
	
	/**
	 * Compares the current guess with the winning number
	 * @param guess the most recent guess the player has made
	 */
	public void determineIfGuessIsCorrect(int guess) {
		if (guess == this.winningNumber) {
			this.correct = true;
		}
	}
	
	/**
	 * Gives a feedback message based on the accuracy of the player's guess
	 * @param guess the most recent guess the player has made
	 * @param language the current language pack being used
	 */
	public void giveFeedback(int guess, LanguagePack language) {
		if (guess < this.winningNumber) {
			language.displayTooLowFeedback();
		} else if  (guess > this.winningNumber) {
			language.displayTooHighFeedback();
		} else {
			language.displayWinFeedback();
		}
	}
	
	/**
	 * Shows the number of guesses and a list of each guess for the current game
	 * @param language the current language pack being used
	 */
	public void showGameStats(LanguagePack language) {
		language.displayNumberOfGuesses();
		System.out.println(this.numGuesses);
		language.displayEachGuess();
		System.out.println(this.playerGuesses);
	}
	
	/**
	 * Asks the user if they want to continue playing or not
	 * If yes, resets the game back to starting conditions
	 * If no, ends the game loop by changing boolean to false and shows all player statistics for current game session
	 * @param player the current instance of player
	 * @param language the current language pack being used
	 */
	public void askToContinuePlaying(GuessingGamePlayer player, LanguagePack language) {
		language.displayContinuePrompt();
		String playAgain = scanner.next();
		if (playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("s")) {
			this.correct = false;
			this.numGuesses = 0;
			clearGuesses();
		} else if (playAgain.equalsIgnoreCase("n")) {
			this.continuePlaying = false;
			showPlayerStatistics(player, language);
		}
	}
	
	/**
	 * Saves the player's current score
	 * @param player the current instance of player
	 */
	public void saveStatistics(GuessingGamePlayer player) {
		player.addToScores(this.numGuesses);
	}
	
	/**
	 * Displays the current player's full statistics for the current game session - name, games played, scores of each game played, average score, best score, worst score
	 * Displays a thank you message to the user
	 * @param player the current instance of player
	 * @param language the current language pack
	 */
	public void showPlayerStatistics(GuessingGamePlayer player, LanguagePack language) {
		System.out.println(player.getName());
		language.displayGamesPlayed();
		System.out.println(player.getNumGamesPlayed());
		System.out.println(player.getScores());
		language.displayAvgScore();
		System.out.println(player.getAvgScore());
		language.displayBestScore();
		System.out.println(player.getBestScore());
		language.displayWorstScore();
		System.out.println(player.getWorstScore());
		language.displayThanks();
	}
	
	/**
	 * Displays the winning number
	 */
	public void displayWinningNum() {
		System.out.println(this.winningNumber);
	}
	
	/**
	 * Clears the list of guesses the player has made
	 */
	public void clearGuesses() {
		this.playerGuesses.clear();
	}
	
	/**
	 * Setter method for the winning number
	 * @param number
	 */
	public void setWinningNumber(int number) {
		this.winningNumber = number;
	}
	
	/**
	 * Getter method for the winning number
	 * @return
	 */
	public int getWinningNumber() {
		return this.winningNumber;
	}
	
	/**
	 * Setter method for the number of guesses
	 * @param number
	 */
	public void setNumGuesses(int number) {
		this.numGuesses = number;
	}
	
	/**
	 * Getter method for the number of guesses
	 * @return
	 */
	public int getNumGuesses() {
		return this.numGuesses;
	}
	
	/**
	 * Setter method for the boolean correct
	 * @param correct
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	/**
	 * Getter method for the boolean correct
	 * @return
	 */
	public boolean isCorrect() {
		return this.correct;
	}

}