package trie;

import java.util.*;



class Node{
	char letter;
	boolean isEndOfWord = false;
	Node parent = null;
	LinkedList<Node> children = new LinkedList<Node>();

	Node(){ }
	Node(char newLetter){
		letter = newLetter;
	}
}

public class Trie {
	boolean VERBOSE = true;
	Node root;

	public Trie(){
		root = new Node();
	};

	public int letterToInt(char letter){
		int number = (int)letter;
//		if (number == 45){
//			number = 0;
//		} else if (number > 64 && number < 91){
//			number -= 64;
//		} else if (number > 96 && number < 123){
//			number -= 70;
//		} else {
//			number = -1;
//		}
		return number;
	}

	public boolean testIndex(int number){
		return (number > -1 && number < 256);
	}

	public boolean objEquals(Object a, Object b){
		return (a == b) || (a != null && a.equals(b));
	}

	public String printNode(Node node){
		if (!objEquals(node, null)){
			return("Data of node is => " + node.letter);
		} else {
			return("Data of node is => " + node);
		}
	}

	public void recursiveSearch(Set<String> setOfWords, Node currentNode, String prefix, int level){
		for (int i = 0; i < currentNode.children.size(); i++){
			if(!objEquals(currentNode.children.get(i), null))
				recursiveSearch(setOfWords, currentNode.children.get(i), prefix + currentNode.children.get(i).letter, level+1);

			if(currentNode.children.get(i).isEndOfWord)
				setOfWords.add(prefix + currentNode.children.get(i).letter);
		}
	}

	public Set<String> returnWords(int mode, String prefix){
		Set<String> setOfWords = new HashSet<>();
		Node currentNode = root;
		int level = 0;

		if (!containsPrefix(prefix))
			return setOfWords;

		for(int i = 0; i < prefix.length(); i++){
			char currentChar = prefix.charAt(i);
			int nodeIndex = currentNode.children.indexOf(currentChar);
			currentNode = currentNode.children.get(nodeIndex);
			level++;
		}

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
		if (VERBOSE) System.out.println("INSERT");
		Node currentNode = root;

		for(int i = 0; i < word.length(); i++){
			char currentChar = word.charAt(i);
			if (objEquals(currentNode.children.contains(currentChar), false)){
				Node newNode = new Node(currentChar);
				currentNode.children.add(newNode);
			}

			if (VERBOSE) {
				System.out.println("Children Nodes");
				for (int x = 0; x < currentNode.children.size(); x++) {
					System.out.println(currentNode.children.get(x).letter);
				}

				System.out.println("Children Nodes Index OF");
				for (int x = 0; x < currentNode.children.size(); x++) {
					System.out.println(currentNode.children.indexOf());
				}
			}

			int nodeIndex = currentNode.children.indexOf(currentChar);
			currentNode = currentNode.children.get(nodeIndex);
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
		System.out.println("CONTAINS");
		Node currentNode = root;

		for(int i = 0; i < word.length(); i++){
			char currentChar = word.charAt(i);
			if (objEquals(currentNode.children.contains(currentChar), false)){
				return false;
			}

			int nodeIndex = currentNode.children.indexOf(currentChar);
			currentNode = currentNode.children.get(nodeIndex);
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
		System.out.println("CONTAINS PREFIX");
		Node currentNode = root;

		for(int i = 0; i < prefix.length(); i++){
			char currentChar = prefix.charAt(i);
			if (objEquals(currentNode.children.contains(currentChar), false)){
				return false;
			}

			int nodeIndex = currentNode.children.indexOf(currentChar);
			currentNode = currentNode.children.get(nodeIndex);
		}
		return true;
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
