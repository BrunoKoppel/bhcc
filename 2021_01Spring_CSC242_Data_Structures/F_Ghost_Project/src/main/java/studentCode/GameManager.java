package studentCode;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
//		System.out.println("\nTurn started");
//		System.out.println("Fragment received => " + fragment);

		AtomicReference<Character> charToReturn = new AtomicReference<>((char) 97);
		AtomicBoolean addInFront = new AtomicBoolean(false);
		listOfALlWords = listOfALlWords.stream().parallel().filter(s -> s.contains(fragment)).filter(s -> (s.length()-fragment.length()) % 2 == 0).collect(Collectors.toSet());

//		System.out.println("\nReading All Current Words in the Dictionary");
//		int i = 0;
//		for (String s : listOfALlWords){
//			i++;
//			System.out.println("Word [" + i + "] => " + s);
//		}

//		System.out.println("\nPicking Characters to return:");
		listOfALlWords.stream().parallel().forEach((s) -> {
//			System.out.println("Analyzing word => " + s);
			int firstIndexOf = s.indexOf(fragment);
//			System.out.println("Index => " + firstIndexOf);
			if (s.length() > firstIndexOf && firstIndexOf != -1){
				charToReturn.set(s.charAt(firstIndexOf - 1));
			} else {

			}

			if (s.length() > (firstIndexOf + fragment.length()) && firstIndexOf != -1){
				charToReturn.set(s.charAt(firstIndexOf + fragment.length()));
			} else {
				charToReturn.set
			}
		});

		System.out.println("Character returned => " + charToReturn.get());

		/*
		 * TurnData.create(char, boolean)
		 * First Parameter (char): a character that you would like to pass to the word fragment.
		 * Second Parameter (boolean): The location the letter will be added to the word fragment, True = add letter to front, False = add letter to back
		 */
		return TurnData.create(charToReturn.get(), addInFront.get());
	}

}
