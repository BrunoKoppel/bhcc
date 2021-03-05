package student;

// http://developer.classpath.org/doc/java/util/LinkedList-source.html


import java.util.Collection;

public class LinkedListDS<E> {

	boolean VERBOSE_ADD1 = false;
	boolean VERBOSE_ADD2 = false;
	boolean VERBOSE_ADDALL1 = false;
	boolean VERBOSE_ADDALL2 = false;
	boolean VERBOSE_CLEAR = false;
	boolean VERBOSE_CONTAINS1 = false;
	boolean VERBOSE_CONTAINSALL1 = false;
	boolean VERBOSE_GET1 = false;
	boolean VERBOSE_GET2 = false;
	boolean VERBOSE_REMOVE1 = false;
	boolean VERBOSE_REMOVE2 = false;
	boolean VERBOSE_REMOVE3 = false;
	boolean VERBOSE_RETAIN = false;
	boolean VERBOSE_SET = false;
	boolean VERBOSE_SIZE = false;

	Node<E> head;
	Node<E> tail;
	int size = 0;

	public static final class Node<E>{
		E data;
		Node<?> pointer;
		Node next;
		Node prev;

		Node(E e){
			data = e;
		}

		Node(E e, Node nextNode, Node prevNode){
			data = e;
			prev = prevNode;
			next = nextNode;
		}
	}

	public LinkedListDS(){}

	public LinkedListDS(Collection<? extends E> c){
		addAll(c);
	}

	private boolean checkBoundsInclusive(int index){
		if (index < 0 || index > size)
			return false;
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		return true;
	}

	private boolean checkBoundsExclusive(int index){
		if (index < 0 || index >= size)
			return false;
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		return true;
	}

	public boolean objEquals(Object a, Object b){
		return (a == b) || (a != null && a.equals(b));
	}

	Node<E> getNode(int index){
		Node<E> currentNode;
		if (index < size/2){
			currentNode = head;
			if (VERBOSE_GET1) System.out.println("Get 1A Node [" + index + "] => " + currentNode.data);
			while(index-- > 0){
				if (VERBOSE_GET1) System.out.println("Get 1B Node [" + index + "] => " + currentNode.data);
				currentNode = currentNode.next;
				if (VERBOSE_GET1) System.out.println("Get 1C Node [" + index + "] => " + currentNode.data);
			}
		} else {
			currentNode = tail;
			if (VERBOSE_GET1) System.out.println("Get 2A Node [" + index + "] => " + currentNode.data);
			while(++index < size){

				if (VERBOSE_GET1) System.out.println("Get 2B Node [" + index + "] => " + currentNode.data);
				currentNode = currentNode.prev;

				if (VERBOSE_GET1) System.out.println("Get 2C Node [" + index + "] => " + currentNode.data);
			}
		}
		return currentNode;
	}

	void removeNode(Node<E> node){
		if (node != null){
			size--;
			if (size == 0)
				head = tail = null;
			else {
				if (node == head){
					head = head.next;
					head.prev = null;
				} else if (node == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
			}
		}
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DS, or -1 if this list does not contain the element.
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		int index = 0;
		Node<E> currentNode = head;
		while(!objEquals(currentNode, null)){
			if (objEquals(currentNode.data, o)){
				return index;
			}

			index++;
			currentNode = currentNode.next;
		}
		return -1;
	}

	public void add(E e){
		Node<E> newNode = new Node<E>(e);
		if (size == 0)
			head = tail = newNode;
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		this.size++;
	}

	/**
	 * Inserts the specified element at the specified position in this DS.
	 * @param index
	 * @param element
	 */
	public void add(int index, E element){
		if (checkBoundsInclusive(index)){
			Node<E> newNode = new Node<E>(element);

			if (index < size){
				Node<E> placeholderNode = getNode(index);
				newNode.next = placeholderNode;

				if (placeholderNode == head){
					head = newNode;
					placeholderNode.prev = head;
					newNode.prev = null;
				} else {
					placeholderNode.prev.next = newNode;
					newNode.prev = placeholderNode.prev;
					placeholderNode.prev = newNode;
				}
				this.size++;

			}
			else
				add(element);
		}
	}

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this DS, in the order that they are held by the specified collection.
	 * @param c
	 * @return
	 */
	public boolean addAll(Collection<? extends E> c){
		return addAll(size, c);
	}

	/**
	 * Inserts all of the elements in the specified collection into this list
	 * at the specified position.
	 * @param index
	 * @param c
	 * @return
	 */
	public boolean addAll(int index, Collection<? extends E> c){
		checkBoundsInclusive(index);
		int csize = c.size();
		Object[] o = c.toArray();

		for (int pos = 0; pos < csize; pos++){
			add(index + pos, (E)o[pos]);
		}

		if (VERBOSE_ADDALL1) System.out.println("Size before resize = " + this.size);
		if (VERBOSE_ADDALL1) System.out.println("Size after resize = " + this.size);
		return true;
	}



	/**
	 * Returns the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	public E get(int index){
		checkBoundsExclusive(index);
		return getNode(index).data;
	}

	/**
	 * Replaces the element at the specified position in this DS with the
	 * specified element.
	 * @param index
	 * @param element
	 * @return
	 */
	public void set(int index, E element){
		checkBoundsExclusive(index);
		Node<E> newNode = getNode(index);
		E old = newNode.data;
		newNode.data = element;
	}


	/**
	 * Returns true if this list contains no elements.
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}

	/**
	 * Removes all of the elements from this DS.
	 */
	public void clear(){
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Removes the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	public E remove(int index){
		checkBoundsExclusive(index);
		Node<E> node = getNode(index);
		removeNode(node);
		return node.data;
	}

	/**
	 * Removes the first occurrence of the specified element from this DS,
	 * if it is present.
	 * @param o
	 * @return
	 */
	public void remove(Object o) {
		removeNode(getNode(indexOf(o)));
	}
	/**
	 * Removes from this DS all of its elements that are contained in the
	 * specified collection.
	 * @param c
	 * @return
	 */
	public void removeAll(Collection<?> c){
		for (Object o : c){
			while(contains(o)){
				removeNode(getNode(indexOf(o)));
			}
		}
	}

	/**
	 * Retains only the elements in this DS that are contained in the specified
	 * collection.
	 * @param c
	 * @return
	 */
	public void retainAll(Collection<?> c){
		int index = 0;
		boolean numberPresent = false;
		while (index < this.size()){
			for (Object o : c){
				if(objEquals(getNode(index).data,o)){
					numberPresent = true;
				}
			}

			if (numberPresent){
				index++;
				numberPresent = false;
			}
			else
				removeNode(getNode(index));

		}


	}

	/**
	 * Returns true if this DS contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		return indexOf(o) != -1;
	}

	/**
	 * Returns true if this list contains all of the elements of the specified
	 * collection.
	 * @param c
	 * @return
	 */
	public boolean containsAll(Collection<?> c){
		int csize = c.size();
		Object[] array = c.toArray();
		for (int i = 0; i < csize; i++){
			if (!contains(array[i])){
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the number of elements in this DS.
	 * @return
	 */
	public int size() {
		return size;
	}
}
