package studentCodeTests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import studentCode.GameManager;
import studentCode.GhostPlayerMain.TurnData;

public class GameManagerTest {

	@Test
	public void winTest() {

		/*
		 * A hypothetical situation where the word fragment is TE this tests that your application has the awareness to
		 * attempt to spell 'test' in order to win. Your application is the first player.
		 *
		 * Why do we want to spell the word 'test'?
		 *
		 * Since 'attention' is an odd length word if your application attempts to spell that word it will lose.
		 * Though 'tempting' is and even length word it is longer than the word 'test', its best if your app chooses
		 * the shorter length words rather than a longer word.
		 */

		HashSet<String> allWords = new HashSet<>();
		
		allWords.add("test");
		allWords.add("attention");
		allWords.add("tempting");
		allWords.add("jump");
		allWords.add("zappos");
		allWords.add("hello");
		
		GameManager manager = new GameManager(2, allWords);

		TurnData turnData = manager.onTurn("te");
		
		assertNotNull(turnData);
		
		assertEquals('s', turnData.getLetter());
		
		assertFalse(turnData.isAddFront());
	}
	
	@Test
	public void loseTest() {

		/*
		 * A hypothetical situation where your opponent starts and the fragment TAC is spelled. This tests that your
		 * app gracefully loses by adding the letter O to spell TACO (There is no possibility to win with the current
		 * letters in you dictionary).
		 *
		 * There are several strategies to lose, when you know you will lose.
		 *
		 * 1) You can gracefully spell a word
		 * 2) Your application can time out. Take to long to play a letter.
		 * 3) Your application can play a letter with no possibility of creating a word.
		 * 4) Your application can play a random letter.
		 *
		 * option 1 is recommended, their is a high chance that a bug can occur in your opponent's application, which
		 * could cause them to lose due to a timeout. In that event your application would win! Basically attempting to
		 * spell the longest word of a set of losing words is your best option when you only have losing words.
 		 */

		HashSet<String> allWords = new HashSet<>();
		
		allWords.add("taco");
		allWords.add("jump");
		allWords.add("zappos");
		allWords.add("hello");
		
		GameManager manager = new GameManager(2, allWords);
						
		TurnData turnData = manager.onTurn("t");
		
		assertNotNull(turnData);
		
		assertEquals('a', turnData.getLetter());
		
		assertFalse(turnData.isAddFront());
		
		turnData = manager.onTurn("tac");
		
		assertNotNull(turnData);
		
		assertEquals('o', turnData.getLetter());
		
		assertFalse(turnData.isAddFront());
	}

}
