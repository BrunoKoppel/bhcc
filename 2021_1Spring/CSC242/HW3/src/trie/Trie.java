package trie;

import java.util.*;

class Node{
	char letter;
	boolean isEndOfWord = false;
	Node[] children = new Node[52];

	Node(){ }

	Node(char newLetter){
		letter = newLetter;
	}
}

public class Trie {

	Node root;
	int wordCount;

	public Trie(){
		root = new Node();
		wordCount = 0;
	};

	public int letterToInt(char letter){
		int number = (int)letter - 65;
		if (number > 26){
			return number - 32;
		}
		return number;
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

	public void printTrie(Node [] array){
		int level = 0;
		for (int i = 0; i < array.length; i++){
			if (!objEquals(array[i], null)){
				System.out.println("Level ["+level+"], Node [" + i + "] => " + printNode(array[i]));
				level++;
				printTrie(array[i].children);
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

	/**
	 * Inserts the specified string into the Trie. The Last node associated to the
	 * of the last char of the specified string will be marked as an end-of-word node.
	 * @param word
	 */
	public void insert(String word){
		char[] array = word.toCharArray();
		Node currentNode = root;
		System.out.println("INSERT");

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			System.out.println(index);
			printNode(currentNode);

			if (objEquals(currentNode.children[index], null))
				currentNode.children[index] = new Node(array[i]);
			else
				currentNode.children[index].letter = array[i];

			currentNode = currentNode.children[index];
			printNode(currentNode);
		}

		currentNode.isEndOfWord = true;
		wordCount++;
	}

	/**
	 * Returns true if this Trie contains the specified string. In other words
	 * the last char of the specified string is a node that is marked as
	 * a end-of-word node.
	 * @param word
	 * @return
	 */
	public boolean contains(String word){
		char[] array = word.toCharArray();
		Node currentNode = root;
		System.out.println("CONTAINS");

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			System.out.println(index);
			printNode(currentNode);

			if (objEquals(currentNode.children[index], null))
				return false;

			currentNode = currentNode.children[index];
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
		System.out.println("CONTAINS PREFIX");

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			System.out.println(index);
			printNode(currentNode);

			if (objEquals(currentNode.children[index], null))
				return false;

			currentNode = currentNode.children[index];
		}
		return true;
	}

	public void recursiveSearch(Set<String> setOfWords, Node currentNode, String prefix){
		for (int i = 0; i < currentNode.children.length; i++){
			if (!objEquals(currentNode.children[i],null)) {
				System.out.println("Current String Stack = " + prefix + " Checking at letter " + currentNode.letter);
				if (currentNode.children[i].isEndOfWord){
					System.out.println("Letter => " + currentNode.children[i].letter);
					System.out.println("Adding = " + prefix + currentNode.children[i].letter);
					setOfWords.add(prefix + currentNode.children[i].letter);
				}
				else {
					currentNode = currentNode.children[i];
					recursiveSearch(setOfWords, currentNode, prefix + currentNode.letter);
				}
			}
		}
	}

	public Set<String> returnWords(int mode, String prefix){
		char[] array = prefix.toCharArray();
		Set<String> setOfWords = null;
		Node currentNode = root;
		int level = 0;

		for(int i = 0; i < array.length; i++){
			int index = letterToInt(array[i]);
			System.out.println(index);
			printNode(currentNode);

			if (objEquals(currentNode.children[index], null))
				return null;

			currentNode = currentNode.children[index];
		}

		System.out.println("Going with letter " + currentNode.letter);
		recursiveSearch(setOfWords, currentNode, prefix);
		return setOfWords;
	}

	/**
	 * Returns all words that begin with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllWords(String prefix){
		System.out.println("GET ALL WORDS");
		return returnWords(0, prefix);
	}

	/**
	 * Returns all words of odd length (odd number of characters) that begin
	 * with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllOddWords(String prefix){
		return null;
	}

	/**
	 * Returns all words of even length (even number of characters) that begin
	 * with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllEvenWords(String prefix){
		return null;
	}

}
