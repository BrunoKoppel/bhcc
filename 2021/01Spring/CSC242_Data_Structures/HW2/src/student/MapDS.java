package student;

import java.util.Collection;
import java.util.Map;

public class MapDS <K, V> {

	boolean VERBOSE_PUT = false;

	int size = 0;

	LinkedListDS<K> keys = new LinkedListDS();
	LinkedListDS<V> values = new LinkedListDS();

	public MapDS(){}

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
		keys.clear();
		values.clear();
	}


	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key){
		return keys.contains(key);
	}


	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value){
		return values.contains(value);
	}


	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 * @param key
	 * @return
	 */
	public V get(Object key){
		int index = keys.indexOf(key);
		return values.get(index);
	}


	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return
	 */
	public boolean isEmpty(){
		return keys.isEmpty();
	}


	/**
	 * Associates the specified value with the specified key in this map.
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		keys.add(key);
		values.add(value);
		keys.tail.pointer = values.tail;
	}


	/**
	 * Copies all of the mappings from the specified map to this map.
	 * @param m
	 */
	public void putAll(Map<? extends K,? extends V> m){
		Collection<K> keyTool = (Collection<K>) m.keySet();
		Object[] arrayKeys = keyTool.toArray();

		for (int i = 0; i < arrayKeys.length; i++){
			keys.add((K)arrayKeys[i]);
			values.add(m.get(arrayKeys[i]));
		}
	}


	/**
	 * Removes the mapping for a key from this map if it is present.
	 * @param key
	 * @return
	 */
	public void remove(Object key){
		while(keys.contains(key)){
			int index = keys.indexOf(key);
			keys.remove(index);
			values.remove(index);
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
		int index = keys.indexOf(key);
		if (!objEquals(values.get(index), null)){
			if (values.get(index) == value){
				keys.remove(index);
				values.remove(index);
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
		if (keys.contains(key)){
			int index = keys.indexOf(key);
			keys.set(index, key);
			values.set(index, value);
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
		if (containsKey(key)){
			if (keys.getNode(keys.indexOf(key)).pointer.data == oldValue)
				replace(key, newValue);
		}
	}


	/**
	 * Returns the number of key-value mappings in this map.
	 * @return
	 */
	public int size(){
		return keys.size();
	}
}
