package trie;

import java.util.*;

class Node{
	char letter;
	boolean isEndOfWord = false;
	Node parent = null;
	Node[] children = new Node[53];

	Node(){ }

	Node(char newLetter){
		letter = newLetter;
	}
}

public class Trie {

	Node root;
//	Set<String> setOfWords;

	public Trie(){
		root = new Node();
//		setOfWords = new HashSet<String>();
	};

	public int letterToInt(char letter){
		int number = (int)letter;
		if (number == 45){
			number = 0;
		} else if (number > 64 && number < 91){
			number -= 64;
		} else if (number > 96 && number < 123){
			number -= 70;
		} else {
			number = -1;
		}
		return number;
	}

	public boolean testIndex(int number){
		return (number > -1 && number < 53);
	}

	public boolean objEquals(Object a, Object b){
		return (a == b) || (a != null && a.equals(b));
	}

	public Node addNode(Node currentNode, char letter){
		int index = letterToInt(letter);
		currentNode.children[index] = new Node(letter);
		return currentNode.children[index];
	}

	public Node getNode(Node currentNode, char letter){
		int index = letterToInt(letter);
		return currentNode.children[index];
	}

	public void printTrie(Node [] array, int level){
		for (int i = 0; i < array.length; i++){
			if (!objEquals(array[i], null)){
				System.out.println("Level ["+level+"], Node [" + i + "] => " + printNode(array[i]));
				level++;
				printTrie(array[i].children, level);
			}
		}
	}

	public String printNode(Node node){
		if (!objEquals(node, null)){
			return("Data of node is => " + node.letter);
		} else {
			return("Data of node is => " + node);
		}
	}

	public void recursiveSearch(Set<String> setOfWords, Node currentNode, String prefix, int level){
//		System.out.println("LEVEL " + level);
		for (int i = 0; i < currentNode.children.length; i++){
//			System.out.println("Iterating = " + i);
			if (!objEquals(currentNode.children[i],null)) {
//				System.out.println("Current String Stack = " + prefix + " Checking at letter " + currentNode.children[i].letter);
				if (currentNode.children[i].isEndOfWord){
//					System.out.println("Letter => " + currentNode.children[i].letter);
//					System.out.println("Adding = " + prefix + currentNode.children[i].letter);
					setOfWords.add(prefix + currentNode.children[i].letter);
				}

				recursiveSearch(setOfWords, currentNode.children[i], prefix + currentNode.children[i].letter, level + 1);
			}
		}
	}

	public Set<String> returnWords(int mode, String prefix){
		Set<String> setOfWords = new HashSet<>();
		char[] array = prefix.toCharArray();
		Node currentNode = root;
		int level = 0;

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			if (testIndex(index)) {
//			System.out.println(index);
//				printNode(currentNode);

				if (!objEquals(currentNode.children[index], null)){
					currentNode = currentNode.children[index];
					level++;
				}
			}
		}

//		System.out.println("Going with letter " + currentNode.letter);
		recursiveSearch(setOfWords, currentNode, prefix, level);
		if (mode == 0){
			return setOfWords;
		}

		Set<String> newSetOfWords = new HashSet<>();
		for (String s : setOfWords){
			System.out.println("Going through " + s);
			if (mode == 1){
				if (s.length() % 2 != 0)
					newSetOfWords.add(s);
			} else {
				if (s.length() % 2 == 0)
					newSetOfWords.add(s);
			}
		}

		return newSetOfWords;
	}

	/**
	 * Inserts the specified string into the Trie. The Last node associated to the
	 * of the last char of the specified string will be marked as an end-of-word node.
	 * @param word
	 */
	public void insert(String word){
		char[] array = word.toCharArray();
		Node currentNode = root;
//		System.out.println("INSERT");

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			if (testIndex(index)){
//			System.out.println(index);
//			printNode(currentNode);

				if (objEquals(currentNode.children[index], null)){
					currentNode.children[index] = new Node(array[i]);
					currentNode.children[index].parent = currentNode;
				} else
					currentNode.children[index].letter = array[i];

				currentNode = currentNode.children[index];
//			printNode(currentNode);
			}
		}

		currentNode.isEndOfWord = true;
//		setOfWords.add(word);
	}

	/**
	 * Returns true if this Trie contains the specified string. In other words
	 * the last char of the specified string is a node that is marked as
	 * a end-of-word node.
	 * @param word
	 * @return
	 */
	public boolean contains(String word){
//		System.out.println("CONTAINS");
//		return setOfWords.contains(word);

		char[] array = word.toCharArray();
		Node currentNode = root;

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			if (testIndex(index)){
				//			System.out.println(index);
//			printNode(currentNode);

				if (objEquals(currentNode.children[index], null))
					return false;

				currentNode = currentNode.children[index];
			}
		}
		return currentNode.isEndOfWord;
	}

	/**
	 * Returns true if this Trie contains the specified string as a word or a
	 * word in the Trie begins with the specified string.
	 * @param prefix
	 * @return
	 */
	public boolean containsPrefix(String prefix){
		char[] array = prefix.toCharArray();
		Node currentNode = root;
//		System.out.println("CONTAINS PREFIX");

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			if (testIndex(index)) {
//			System.out.println(index);
//			printNode(currentNode);

				if (objEquals(currentNode.children[index], null))
					return false;

				currentNode = currentNode.children[index];
			}
		}
		return currentNode.isEndOfWord;
		//return true;
	}

	/**
	 * Returns all words that begin with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllWords(String prefix){
//		System.out.println("GET ALL WORDS");
		return returnWords(0, prefix);
	}

	/**
	 * Returns all words of odd length (odd number of characters) that begin
	 * with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllOddWords(String prefix){
		return returnWords(1, prefix);
	}

	/**
	 * Returns all words of even length (even number of characters) that begin
	 * with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllEvenWords(String prefix){
		return returnWords(2, prefix);
	}
}
