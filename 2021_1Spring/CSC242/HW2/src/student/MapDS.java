package student;

import java.util.Collection;
import java.util.Map;

public class MapDS <K, V> {

	boolean VERBOSE_PUT = false;



	int size = 0;
	valueNode[] hashMap = new valueNode[1000];

	public MapDS(){
	}

	public final class valueNode<K, V>{
		K key;
		V value;
		valueNode next;
		valueNode prev;

		valueNode(K k, V v){
			key = k;
			value = v;
		}

		valueNode(K k, V v, valueNode nextNode, valueNode prevNode){
			key = k;
			value = v;
			next = nextNode;
			prev = prevNode;
		}
	}

	public void insert(valueNode[] array,K key, V value){
		int location = generateHashKey(key, array.length);
		array[location].value = value;
	}

	public int generateHashKey(K key, int arrayLength){
		int rawKey = key.hashCode();
		return Math.abs(rawKey % arrayLength);
	}

	public void addNode(K key, V value){
		valueNode<K, V> newNode = new valueNode<K, V>(key, value);
		//int location = hashKey(value, hashMap.length);
		if (hashMap[(int)key] != null){
			 hashMap[(int)key].next = newNode;
		} else {
			hashMap[(int)key] = newNode;
		}
	}

	public void removeNode(K key){

	}

	/**
	 * Removes all of the mappings from this map.
	 */
	public void clear(){
		for (int i = 0; i < hashMap.length; i++){
			hashMap[i] = null;
		}
	}


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key){
		return hashMap[(int)key] != null;
	}


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value){
		for (int i = 0; i < hashMap.length; i++){
			if(hashMap[i].value == value){
				return true;
			}
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
		int location = generateHashKey((K) key, hashMap.length);
		return (V) hashMap[location].value;
	}


	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return
	 */
	public boolean isEmpty(){
		for (int i = 0; i < hashMap.length; i++){
			if(hashMap[i] != null){
				return false;
			}
		}
		return true;
	}


	/**
	 * Associates the specified value with the specified key in this map.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		if (value == null){
			throw new NullPointerException();
		}

		valueNode newNode = new valueNode(key, value);
		if (VERBOSE_PUT) {
			System.out.println("Key => " + key);
			System.out.println("Value => " + value);
			System.out.println("Length of HashMap => " + hashMap.length);
		}
		int location = generateHashKey(key, hashMap.length);

		if (VERBOSE_PUT) {
			System.out.println("Location => " + location);
		}

		if (hashMap[location] == null){
			size++;
		}
		hashMap[location] = newNode;
	}


	/**
	 * Copies all of the mappings from the specified map to this map.
	 * @param m
	 */
	public void putAll(Map<? extends K,? extends V> m){
		Collection<K> keys = (Collection<K>) m.keySet();
		Collection<V> values = (Collection<V>) m.values();
		Object[] arrayKeys = keys.toArray();
		Object[] arrayValues = values.toArray();

		for (int i = 0; i < values.size(); i++){
			if (arrayValues[i] == null){
				throw new NullPointerException();
			}

			valueNode newNode = new valueNode(arrayKeys[i], arrayValues[i]);
			int location = generateHashKey((K) arrayKeys[i], hashMap.length);
			if (hashMap[location] == null){
				size++;
			}
			hashMap[location] = newNode;
		}

	}


	/**
	 * Removes the mapping for a key from this map if it is present.
	 * @param key
	 * @return
	 */
	public void remove(Object key){
		int location = generateHashKey((K) key, hashMap.length);
		if (hashMap[location] != null){
			size--;
			hashMap[location] = null;
		}
	}


	/**
	 * Removes the entry for the specified key only if it is currently mapped to the 
	 * specified value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void remove(Object key, Object value){
		int location = generateHashKey((K) key, hashMap.length);
		if (hashMap[location].value == value){
			size--;
			hashMap[location] = null;
		}
	}


	/**
	 * Replaces the entry for the specified key only if it is currently mapped to some value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void replace(K key, V value){
		int location = generateHashKey((K) key, hashMap.length);
		if (value == null){
			throw new NullPointerException();
		}

		if (hashMap[location] != null){
			valueNode newNode = new valueNode(key, value);
			hashMap[location] = newNode;
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
		int location = generateHashKey((K) key, hashMap.length);

		if (oldValue == null || newValue == null){
			throw new NullPointerException();
		}

		if (hashMap[location] != null){
			if (hashMap[location].value == oldValue){
				valueNode newNode = new valueNode(key, newValue);
				hashMap[location] = newNode;
			}
		}
	}

	
	/**
	 * Returns the number of key-value mappings in this map.
	 * @return
	 */
	public int size(){
		return this.size;
	}
}
