package trie;

import java.util.Set;

public class Trie {

	Node root;

	public static final class Node{
		char data;
		boolean isEndOfWord = false;

		Node a; // 97
		Node b; // 98
		Node c; // 99
		Node d; // 100
		Node e; // 101
		Node f; // 102
		Node g; // 103
		Node h; // 104
		Node i; // 105
		Node j; // 106
		Node k; // 107
		Node l; // 108
		Node m; // 109
		Node n; // 110
		Node o; // 111
		Node p; // 112
		Node q; // 113
		Node r; // 114
		Node s; // 115
		Node t; // 116
		Node u; // 117
		Node v; // 118
		Node w; // 119
		Node x; // 120
		Node y; // 121
		Node z; // 122

		Node(char letter){
			data = letter;
		}


	}

	Trie(){
		root = null;
	};

	public boolean objEquals(Object a, Object b){
		return (a == b) || (a != null && a.equals(b));
	}

	public Node addNode(Node currentNode, char letter){

		switch ((int)letter){
			case 97:
				currentNode.a.data = new Node(letter);
				return currentNode.a;

			case 98:
				currentNode.b.data = letter;
				return currentNode.b;

			case 99:
				currentNode.c.data = letter;
				return currentNode.c;

			case 100:
				currentNode.d.data = letter;
				return currentNode.d;

			case 101:
				currentNode.e.data = letter;
				return currentNode.e;

			case 102:
				currentNode.f.data = letter;
				return currentNode.f;

			case 103:
				currentNode.g.data = letter;
				return currentNode.g;

			case 104:
				currentNode.h.data = letter;
				return currentNode.h;

			case 105:
				currentNode.i.data = letter;
				return currentNode.i;

			case 106:
				currentNode.j.data = letter;
				return currentNode.j;

			case 107:
				currentNode.k.data = letter;
				return currentNode.k;

			case 108:
				currentNode.l.data = letter;
				return currentNode.l;

			case 109:
				currentNode.m.data = letter;
				return currentNode.m;

			case 110:
				currentNode.n.data = letter;
				return currentNode.n;

			case 111:
				currentNode.o.data = letter;
				return currentNode.o;

			case 112:
				currentNode.p.data = letter;
				return currentNode.p;

			case 113:
				currentNode.q.data = letter;
				return currentNode.q;

			case 114:
				currentNode.r.data = letter;
				return currentNode.r;

			case 115:
				currentNode.s.data = letter;
				return currentNode.s;

			case 116:
				currentNode.t.data = letter;
				return currentNode.t;

			case 117:
				currentNode.u.data = letter;
				return currentNode.u;

			case 118:
				currentNode.v.data = letter;
				return currentNode.v;

			case 119:
				currentNode.w.data = letter;
				return currentNode.w;

			case 120:
				currentNode.x.data = letter;
				return currentNode.x;

			case 121:
				currentNode.y.data = letter;
				return currentNode.y;

			case 122:
				currentNode.z.data = letter;
				return currentNode.z;

			default:
				return null;
		}
	}

	public Node getNode(Node currentNode, char letter){
		switch ((int)(letter)){
			case 97:
				return currentNode.a;

			case 98:
				return currentNode.b;

			case 99:
				return currentNode.c;

			case 100:
				return currentNode.d;

			case 101:
				return currentNode.e;

			case 102:
				return currentNode.f;

			case 103:
				return currentNode.g;

			case 104:
				return currentNode.h;

			case 105:
				return currentNode.i;

			case 106:
				return currentNode.j;

			case 107:
				return currentNode.k;

			case 108:
				return currentNode.l;

			case 109:
				return currentNode.m;

			case 110:
				return currentNode.n;

			case 111:
				return currentNode.o;

			case 112:
				return currentNode.p;

			case 113:
				return currentNode.q;

			case 114:
				return currentNode.r;

			case 115:
				return currentNode.s;

			case 116:
				return currentNode.t;

			case 117:
				return currentNode.u;

			case 118:
				return currentNode.v;

			case 119:
				return currentNode.w;

			case 120:
				return currentNode.x;

			case 121:
				return currentNode.y;

			case 122:
				return currentNode.z;

			default:
				return null;
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
		for(char letter: array){
			currentNode = addNode(currentNode, letter);
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
		Node currentNode = root;
		for (int i = 0; i < array.length; i++){
			currentNode = getNode(currentNode, array[i]);
			if (objEquals(currentNode.data, null))
				return false;
		}
		if (currentNode.isEndOfWord)
			return true;
		return false;
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
		for (int i = 0; i < array.length; i++){
			currentNode = getNode(currentNode, array[i]);
			if (objEquals(currentNode.data, null))
				return false;
		}
		return true;
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
