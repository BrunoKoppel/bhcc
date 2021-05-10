package studentCode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import studentCode.GhostPlayerMain.TurnData;

/**
 * This class is your application's brain. It will be used by the GhostPlayerMain class to get letter 
 * and location of the letter for each game turn. 
 * 
 * 
 * @author Student
 *
 */
public class GameManager {

	int minWordLength;
	Set<String> listOfALlWords;
	/**
	 * This method will get called once when your application is started up. You should use this to initialize
	 * your application by setting up your necessary data structures other classes. You will be given 
	 * a number denoting the minimum winning word length as well as a set containing all the English words in 
	 * the dictionary (>700K words)   
	 * @param minWordLength A value denoting the minimum length the fragment must to be consider as a word 
	 * and for losing condition.  
	 * @param allWords All the words on the English language this is >700K elements.
	 */
	public GameManager(int minWordLength, Set<String> allWords) {
		this.minWordLength = minWordLength;
		listOfALlWords = allWords.stream().parallel().filter(s -> s.length() >= minWordLength).collect(Collectors.toSet());
	}
	
	/**
	 * This method is called every round you will be given the current word fragment of the game.
	 * In this method you will figure out the next letter and the location of the letter.
	 * @param fragment The current ordered collection of letters that have been played in the game.
	 * @return An object that contains information about letter and location on the next turn.
	 */
	public TurnData onTurn(String fragment) {
		listOfALlWords.stream().parallel().filter(s -> s.contains(fragment)).forEach();

		/*
		 * TurnData.create(char, boolean)
		 * First Parameter (char): a character that you would like to pass to the word fragment.
		 * Second Parameter (boolean): The location the letter will be added to the word fragment, True = add letter to front, False = add letter to back
		 */
		return TurnData.create(null, null);
	}

}
