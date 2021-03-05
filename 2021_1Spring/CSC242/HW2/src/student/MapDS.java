package student;

import java.util.Collection;
import java.util.Map;

public class MapDS <K, V> {

	boolean VERBOSE_PUT = true;

	int arrayLength = 1000;
	int size = 0;
	LinkedListDS<valueNode<K, V>>[] hashMap = new LinkedListDS[arrayLength];

	public MapDS(){
		for (int i = 0; i < arrayLength; i++)
			hashMap[i] = new LinkedListDS<valueNode<K,V>>();
	}

	public MapDS(K k, V v){
		for (int i = 0; i < arrayLength; i++)
			hashMap[i] = new LinkedListDS<valueNode<K,V>>();
	}

	public final class valueNode<K, V>{
		K key;
		V value;

		valueNode(K k, V v){
			key = k;
			value = v;
		}
	}

	public boolean objEquals(Object a, Object b){
		return (a == b) || (a != null && a.equals(b));
	}

	public int generateHashKey(K key, int arrayLength){
		int rawKey = key.hashCode();
		return Math.abs(rawKey % arrayLength);
	}

	/**
	 * Removes all of the mappings from this map.
	 */
	public void clear(){
		size = 0;
		for (int i = 0; i < arrayLength; i++){
			hashMap[i] = null;
		}
	}


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key){
		int location = generateHashKey(key, arrayLength);
		return objEquals(hashMap[location],null);
	}


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value){
		for (int i = 0; i < arrayLength; i++){
			for (int y = 0; i < hashMap[i].size; y++){
				if (objEquals(hashMap[i].getNode(y).data.value, value)){
					return true;
				}
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
		return (V) hashMap[location].getNode(0).data.value;
	}


	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return
	 */
	public boolean isEmpty(){
		for (int i = 0; i < arrayLength; i++){
			if(!objEquals(hashMap[i].getNode(i), null)){
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
		valueNode newNode = new valueNode(key, value);

		if (VERBOSE_PUT) {
			System.out.println("\n\nPutting Node into HashMap");
			System.out.println("Node created => [" + newNode.key + "][" + newNode.value + "]");
			System.out.println("Length of HashMap => " + hashMap.length);
		}

		int location = generateHashKey(key, arrayLength);

		if (VERBOSE_PUT){
			System.out.println("Location => " + location);
			System.out.println("Size at Location = " + hashMap[location].size());
			System.out.println("Location for NewNode = " + hashMap[location].getNode(0));
		}

		hashMap[location].add(newNode);

		if (VERBOSE_PUT){
			System.out.println("NewNode in location = " + hashMap[location].getNode(0));
			System.out.println("Values of NewNode in location [" + hashMap[location].getNode(0).data.key + "][" + hashMap[location].getNode(0).data.value + "]");
			System.out.println("Size at Location = " + hashMap[location].size());
			System.out.println("End of Put Function\n");
		}
	}


	/**
	 * Copies all of the mappings from the specified map to this map.
	 * @param m
	 */
	public void putAll(Map<? extends K,? extends V> m){
		Collection<K> keys = (Collection<K>) m.keySet();
		Object[] arrayKeys = keys.toArray();

		for (int i = 0; i < arrayKeys.length; i++){
			put((K)arrayKeys[i], m.get((K)arrayKeys[i]));
		}
	}


	/**
	 * Removes the mapping for a key from this map if it is present.
	 * @param key
	 * @return
	 */
	public void remove(Object key){
		int location = generateHashKey((K) key, arrayLength);
		int sizeToDelete = hashMap[location].size;
		hashMap[location].clear();
		size -= sizeToDelete;
	}


	/**
	 * Removes the entry for the specified key only if it is currently mapped to the 
	 * specified value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void remove(Object key, Object value){
		valueNode nodeToDelete = new valueNode(key, value);
		int location = generateHashKey((K) key, arrayLength);
		for (int i = hashMap[location].size; i >= 0; i--){
			V valueOfNode = hashMap[location].getNode(i).data.value;
			if (objEquals(valueOfNode, value)){
				hashMap[location].remove(i);
				size--;
			}
		}
	}


	/**
	 * Replaces the entry for the specified key only if it is currently mapped to some value.
	 * @param key
	 * @param value
	 * @return
	 */
	public void replace(K key, V value){
		valueNode newNode = new valueNode(key, value);
		int location = generateHashKey((K) key, arrayLength);
		if (!objEquals(hashMap[location], null)){
			hashMap[location].clear();
			hashMap[location].add(newNode);
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
		valueNode newNode = new valueNode(key, newValue);
		int location = generateHashKey((K) key, arrayLength);

		if (!objEquals(oldValue, null) && !objEquals(newValue, null)){
			for (int i = 0; i < hashMap[location].size; i++){
				if (objEquals(hashMap[location].getNode(i).data.value,oldValue)){
					hashMap[location].set(i, newNode);
				}
			}
		}
	}


	/**
	 * Returns the number of key-value mappings in this map.
	 * @return
	 */
	public int size(){
		int sizeSum = 0;
		for (int i = 0; i < arrayLength; i++){
			sizeSum += hashMap[i].size();
		}
		return sizeSum;
	}
}
