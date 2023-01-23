package com.fettig.guessANumber;

/****

<b>Title:</b> LanguagePack.java<br>
<b>Project:</b> guessingGame<br>
<b>Description:</b>
	Language pack for use with Guessing Game. Supports an English and a Spanish version
	Holds a number of prompts as variables and assigns them in the constructor based on the user input
<br>
<b>Copyright:</b> Copyright (c) 2023<br>
<b>Company:</b> Silicon Mountain Technologies<br>
@author Tom Fettig
@version 1.0
@since Jan 10 2023
@updates:

****/

public class LanguagePack {
	
	//Member variables to store each prompt that is used for the game
	private String welcome;
	private String numberPrompt;
	private String guessPrompt;
	private String winFeedback;
	private String tooLowFeedback;
	private String tooHighFeedback;
	private String askToContinue;
	private String numberOfGuesses;
	private String eachGuess;
	private String gamesPlayed;
	private String avgScore;
	private String bestScore;
	private String worstScore;
	private String thanks;
	
	public LanguagePack(String language) {
		if (language.equalsIgnoreCase("english")) {
			this.welcome = "Welcome to Guessing Game! What is your name?";
			this.numberPrompt = "What do you want to use as a maximum possible number?";
			this.guessPrompt = "Make a guess: ";
			this.winFeedback = "Correct, you win!";
			this.tooLowFeedback = "Nope, your guess was too low, try again!";
			this.tooHighFeedback = "Nope, your guess was too high, try again!";
			this.askToContinue = "Do you want to keep playing? y/n";
			this.numberOfGuesses = "Number of guesses it took you to win: ";
			this.eachGuess = "Here is a list of all of your guesses: ";
			this.gamesPlayed = "Games played: ";
			this.avgScore = "Your average score was: ";
			this.bestScore = "Your best score was: ";
			this.worstScore = "Your worst score was: ";
			this.thanks = "Thanks for playing!";
		} else if (language.equalsIgnoreCase("spanish")) {
			this.welcome = "¡Bienvenido al juego de adivinanzas! ¿Cómo te llamas?";
			this.numberPrompt = "¿Qué quieres usar como número máximo posible?";
			this.guessPrompt = "Adivina: ";
			this.winFeedback = "¡Correcto, tú ganas!";
			this.tooLowFeedback = "No, tu conjetura fue demasiado baja, ¡inténtalo de nuevo!";
			this.tooHighFeedback = "No, tu suposición fue demasiado alta, ¡inténtalo de nuevo!";
			this.askToContinue = "¿Quieres seguir jugando? s/n";
			this.numberOfGuesses = "Número de intentos que te tomó ganar: ";
			this.eachGuess = "Aquí hay una lista de todas sus conjeturas: ";
			this.gamesPlayed = "Juegos jugados: ";
			this.avgScore = "Su puntaje promedio fue: ";
			this.bestScore = "Tu mejor puntuación fue: ";
			this.worstScore = "Tu peor puntuación fue: ";
			this.thanks = "¡Gracias por jugar!";
		}
	}

	/**
	 * Displays the welcome message
	 */
	public void displayWelcome() {
		System.out.println(this.welcome);
	}
	
	/**
	 * Displays the prompt asking what number range the user wants to play with
	 */
	public void displayNumberPrompt() {
		System.out.println(this.numberPrompt);
	}
	
	/**
	 * Displays the prompt asking the user to make a guess
	 */
	public void displayGuessPrompt() {
		System.out.println(this.guessPrompt);
	}
	
	/**
	 * Displays the feedback given when the user guesses the correct number
	 */
	public void displayWinFeedback() {
		System.out.println(this.winFeedback);
	}
	
	/**
	 * Displays the feedback given when the guess is lower than the winning number
	 */
	public void displayTooLowFeedback() {
		System.out.println(this.tooLowFeedback);
	}
	
	/**
	 * Displays the feedback given when the guess is higher than the winning number
	 */
	public void displayTooHighFeedback() {
		System.out.println(this.tooHighFeedback);
	}
	
	/**
	 * Displays the prompt to ask if player wants to continue playing
	 */
	public void displayContinuePrompt() {
		System.out.println(this.askToContinue);
	}
	
	/**
	 * Displays a prompt for the number of guesses the user took before getting to the winning number
	 */
	public void displayNumberOfGuesses() {
		System.out.print(this.numberOfGuesses);
	}
	
	/**
	 * Displays a prompt for the complete ArrayList of each number the user guessed
	 */
	public void displayEachGuess() {
		System.out.print(this.eachGuess);
	}
	
	/**
	 * Displays a prompt for the number of games a user has played
	 */
	public void displayGamesPlayed() {
		System.out.print(this.gamesPlayed);
	}
	
	/**
	 * Displays a prompt for the average score of all of the user's games played
	 */
	public void displayAvgScore() {
		System.out.print(this.avgScore);
	}
	
	/**
	 * Displays a prompt for the user's best score
	 */
	public void displayBestScore() {
		System.out.print(this.bestScore);
	}
	
	/**
	 * Displays a prompt for the user's worst score
	 */
	public void displayWorstScore() {
		System.out.print(this.worstScore);
	}
	
	/**
	 * Displays a thank you message to the user
	 */
	public void displayThanks() {
		System.out.print(this.thanks);
	}
}