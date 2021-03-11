package trie;

import java.util.Set;

public class Trie {

	Node[] parent = new Node[52];

	public static final class Node{
		char data;
		boolean isEndOfWord = false;
		Node[] children = new Node[52];

		Node(){
			for(int i = 0; i < 52; i++){
				children[i] = null;
			}
		}

		Node(char letter){
			data = letter;
			for(int i = 0; i < 52; i++){
				children[i] = null;
			}
		}
	}

	Trie(){
		for(int i = 0; i < 52; i++){
			parent[i] = null;
		}
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
		for (int i = 0; i < array.length; i++){
			System.out.println("Data of Node [" + i + "] => " + printNode(array[i]));

		}
	}

	public String printNode(Node node){
		if (!objEquals(node, null)){
			return("Data of node is => " + node.data);
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
		Node currentNode = parent[letterToInt(array[0])];
		System.out.println("Printing insert output");

		for(int i = 0; i < array.length; i++){
			System.out.println(letterToInt(array[i]));

//			printNode(currentNode);
			currentNode = new Node(array[i]);
			printNode(currentNode);

			if (i < array.length - 1)
				currentNode = currentNode.children[letterToInt(array[i + 1])];
		}

		currentNode.isEndOfWord = true;
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
		Node currentNode = parent[letterToInt(array[0])];
		System.out.println("Printing contains output");

		for(int i = 0; i < array.length; i++){
			System.out.println(letterToInt(array[i]));
			printNode(currentNode);
			if (objEquals(currentNode.data, null))
				return false;

			if (i < array.length - 1)
				currentNode = currentNode.children[letterToInt(array[i + 1])];
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
		return false;
	}

	/**
	 * Returns all words that begin with the specified prefix.
	 * @param prefix
	 * @return
	 */
	public Set<String> getAllWords(String prefix){
		return null;
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
