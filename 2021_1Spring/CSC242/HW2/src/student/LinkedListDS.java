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

	transient Node<E> head;
	transient Node<E> tail;
	transient int size = 0;

	public static final class Node<E>{
		E data;
		Node next;
		Node prev;

		Node(E e){
			data = e;
		}

		Node(E e, Node next, Node prev){
			this.data = e;
			this.prev = prev;
			this.next = next;
		}
	}

	Node<E> getNode(int index){
		Node<E> currentNode;
		if (index < size/2){
			currentNode = head;
			while(index-- > 0)
				currentNode = currentNode.next;
		} else {
			currentNode = tail;
			while(++index < size){
				currentNode = currentNode.prev;
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
					head = node.next;
					node.next.prev = null;
				} else if (node == tail) {
					tail = node.prev;
					node.prev.next = null;
				} else {
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
			}
		}
	}

	private void checkBoundsInclusive(int index){
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	private void checkBoundsExclusive(int index){
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	public LinkedListDS(){}

	public LinkedListDS(Collection<? extends E> c){
		addAll(c);
	}

	public E getFirst() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		return head.data;
	}

	public E getLast() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		return tail.data;
	}

	public E removeFirst() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		size--;
		E r = head.data;

		if (head.next != null)
			head.next.prev = null;
		else
			tail = null;

		head = head.next;

		return r;
	}

	public E removeLast() {
		if (size == 0)
			throw new IndexOutOfBoundsException();
		size--;

		E r = tail.data;

		if (tail.prev != null)
			tail.prev.next = null;
		else
			head = null;

		tail = tail.prev;

		return r;
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node(e);

		if (size == 0)
			head = tail = newNode;
		else{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(E e) {
		addLastNode(new Node<E>(e));
	}

	private void addLastNode(Node<E> newNode){
		if (size == 0)
			head = tail = newNode;
		else
		{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}


	/**
	 * Returns true if this DS contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		Node<E> currentNode = head;
		while (currentNode != null){
			if (currentNode.data.equals(o))
				return true;
			currentNode = currentNode.next;
		}
		return false;
	}

	/**
	 * Returns the number of elements in this DS.
	 * @return
	 */
	public int size() {
		return size;
	}

	public void add(E e){
		addLastNode(new Node<E>(e));
	}

	/**
	 * Removes the first occurrence of the specified element from this DS,
	 * if it is present.
	 * @param o
	 * @return
	 */
	public void remove(Object o) {
		Node<E> currentNode = head;
		while(currentNode != null){
			if (currentNode.data.equals(o)){
				removeNode(currentNode);
			}
			currentNode = currentNode.next;
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

		if (csize == 0)
			return false;

		Node<E> after = null;
		Node<E> before = null;

		if (index != this.size){
			before = getNode(index);
			after = before.prev;
		} else
			after = tail;

		Object[] o = c.toArray();
		Node<E> newNode = new Node<E>((E)o[0]);

		newNode.prev = after;
		Node<E> previous = newNode;
		Node<E> newHead = newNode;

		for (int pos = 1; pos < csize; pos++){
			newNode = new Node<E>((E)o[pos]);
			previous.next = newNode;
			newNode.prev = previous;
			previous = newNode;
		}

		if (VERBOSE_ADDALL1) System.out.println("Size before resize = " + this.size);
		this.size += csize;
		if (VERBOSE_ADDALL1) System.out.println("Size after resize = " + this.size);


		if (before != null){
			previous.prev = newNode;
			newNode.next = before;
		} else {
			tail = newNode;
		}

		if (after != null) {
			after.next = newHead;
		} else {
			head = newHead;
		}

		return true;
	}

	/**
	 * Removes all of the elements from this DS.
	 */
	public void clear(){
		if (size > 0){
			head = null;
			tail = null;
			size = 0;
		}
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
	 * Inserts the specified element at the specified position in this DS.
	 * @param index
	 * @param element
	 */
	public void add(int index, E element){
		checkBoundsInclusive(index);
		Node<E> newNode = new Node<E>(element);

		if (index < size){
			Node<E> after = getNode(index);
			newNode.next = after;
			newNode.prev = after.prev;
			if (after.prev == null)
				head = newNode;
			else
				after.prev.next = newNode;
			after.prev = newNode;
			size++;
		}
		else
			addLastNode(newNode);
	}

	/**
	 * Removes the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	public E remove(int index){
		System.out.println("Hello From Remove at Index");

		checkBoundsExclusive(index);
		Node<E> node = getNode(index);
		removeNode(node);
		return node.data;
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
		while(currentNode != null){
			if (currentNode.data.equals(o))
				return index;
			index++;
			currentNode = currentNode.next;
		}
		return -1;
	}

	public int lastIndexOf(Object o){
		int index = size - 1;
		Node<E> currentNode = tail;
		while (currentNode != null){
			if (currentNode.data.equals(o))
				return index;
			index--;
			currentNode = currentNode.prev;
		}
		return -1;
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}

	/**
	 * Returns true if this list contains all of the elements of the specified
	 * collection.
	 * @param c
	 * @return
	 */
	public boolean containsAll(Collection<?> c){
		int csize = c.size();
		int numbersEqualToCollection = 0;
		for (Object o : c){
			if (VERBOSE_CONTAINSALL1) System.out.println("Value entered is => " + o);
			Node currentNode = head;
			while (currentNode != null){

				if (VERBOSE_CONTAINSALL1) System.out.println("Analyzing value => " + currentNode.data);

				if (currentNode.data.equals(o)){
					if (VERBOSE_CONTAINSALL1) System.out.println("Value is in Collection !!");

					numbersEqualToCollection++;
					break;
				}

				if (VERBOSE_CONTAINSALL1) System.out.println("Next node == " + currentNode.next);
				if (currentNode.next != null)
					currentNode = currentNode.next;
			}
		}
		if (VERBOSE_CONTAINSALL1) System.out.println("Size of Collection VS NumbersContained [" + csize + "][" + numbersEqualToCollection + "]");
		return csize == numbersEqualToCollection;
	}

	/**
	 * Removes from this DS all of its elements that are contained in the
	 * specified collection.
	 * @param c
	 * @return
	 */
	public void removeAll(Collection<?> c){
		System.out.println("Hello From Remove All");
		for (Object o : c){
			Node<E> currentNode = head;
			while (currentNode != null){
				if (currentNode.data.equals(o)){
					Node<E> nodeToEliminate = currentNode;
					removeNode(nodeToEliminate);
				}
				currentNode = currentNode.next;
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
		System.out.println("Hello From Retain All");
		Node<E> currentNode = head;
		while (currentNode != null){
			boolean isCurrentNodePresent = false;
			for (Object o : c){
				if (currentNode.data.equals(o))
					isCurrentNodePresent = true;
			}

			if (!isCurrentNodePresent){
				Node<E> nodeToEliminate = currentNode;
				removeNode(nodeToEliminate);
			}

			currentNode = currentNode.next;
		}
	}
}
