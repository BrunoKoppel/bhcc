package student;

import java.util.AbstractMap;
import java.util.Map;

public class MapDS <K, V> {

	transient keyNode<K> keyHead;
	transient keyNode<K> keyTail;
	transient valueNode<V> valueHead;
	transient valueNode<V> valueTail;
	transient int size = 0;

	public static final class keyNode<K>{
		K key;
		valueNode
		keyNode next;
		keyNode prev;


		keyNode(K k){
			key = k;
		}

		keyNode(K k, keyNode nextNode, keyNode prevNode){
			key = k;
			next = nextNode;
			prev = prevNode;
		}
	}

	public static final class valueNode<V>{
		V value;
		keyNode next;
		keyNode prev;


		valueNode(V v){
			value = v;
		}

		valueNode(V v, keyNode nextNode, keyNode prevNode){
			value = v;
			next = nextNode;
			prev = prevNode;
		}
	}

	public void addNode(K key, V value){
		Node<K, V> newNode = new Node<K, V>(key, value);
		if (size == 0){
			head = tail = newNode;
		} else {
			tail.next = newNode;
		}
	}

	public void addNode(Node<K, V> newNode){
		if (size == 0){
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = newNode;
		}
	}

	public void removeNode(K key){
		
	}

	/**
	 * Removes all of the mappings from this map.
	 */
	public void clear(){
		head = tail = null;
	}


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key){
		Node<K, V> currentNode = head;
		while(currentNode != null){
			if (currentNode.key == key){
				return true;
			} 
			
			currentNode = currentNode.next;
		}
		return false;
	}


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value){
		Node<K, V> currentNode = head;
		while(currentNode != null){
			if (currentNode.value == value){
				return true;
			}

			currentNode = currentNode.next;
		}
		return false;
	}


	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 * @param key
	 * @return
	 */
	public V get(Object key){
		Node<K, V> currentNode = head;
		while(currentNode != null){
			if (currentNode.key == key){
				return currentNode.value;
			}

			currentNode = currentNode.next;
		}
		return null;
	}


	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}


	/**
	 * Associates the specified value with the specified key in this map.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		boolean keyInHash = false;
		Node<K, V> newNode = new Node<K, V>(key, value);
		Node<K, V> currentNode = head;
		while(currentNode != null){
			if (currentNode.key == key){
				keyInHash = true;
				break;
			}

			currentNode = currentNode.next;
		}

		if (keyInHash){
			replace(key, value);
		} else {
			addNode(newNode);
		}
	}


	/**
	 * Copies all of the mappings from the specified map to this map.
	 * @param m
	 */
	public void putAll(Map<? extends K,? extends V> m){

	}


	/**
	 * Removes the mapping for a key from this map if it is present.
	 * @param key
	 * @return
	 */
	public void remove(Object key){

	}


	/**
	 * Removes the entry for the specified key only if it is currently mapped to the 
	 * specified value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void remove(Object key, Object value){

	}


	/**
	 * Replaces the entry for the specified key only if it is currently mapped to some value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void replace(K key, V value){
		Node<K, V> currentNode = head;
		while(currentNode != null){
			if(key == currentNode.key)
				currentNode.value = value;

			currentNode = currentNode.next;
		}
	}

	
	/**
	 * Replaces the entry for the specified key only if currently mapped to the 
	 * @param key
	 * @param oldValue
	 * @param newValue
	 * @return
	 */
	public void replace(K key, V oldValue, V newValue){
		Node<K, V> currentNode = getInitialNode(key);
		while (currentNode.paralel != null){
			if (currentNode.value == oldValue){
				currentNode.value = newValue;
			}

			currentNode = currentNode.paralel;
		}
	}

	
	/**
	 * Returns the number of key-value mappings in this map.
	 * @return
	 */
	public int size(){
		return this.size;
	}

	public keyNode getNode(K key){
		keyNode<K> currentNode = keyHead;
		while(currentNode != null){
			if(key == currentNode.key){
				return currentNode;
			}

			currentNode = currentNode.next;
		}
		return null;
	}
}
