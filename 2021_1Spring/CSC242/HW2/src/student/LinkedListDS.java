package student;

// http://developer.classpath.org/doc/java/util/LinkedList-source.html

import java.util.Collection;

public class LinkedListDS<E> {


	boolean VERBOSE_ADD1 = false;
	boolean VERBOSE_ADD2 = false;
	boolean VERBOSE_ADDALL1 = false;
	boolean VERBOSE_ADDALL2 = true;
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

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DS, or -1 if this list does not contain the element.
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		if (o != null){
			int index = 0;
			Node<E> currentNode = head;
			while(currentNode != null){
				if (currentNode.data != null){
					if (currentNode.data.equals(o)){
						return index;
					}

					index++;
					currentNode = currentNode.next;

				} else {
					break;
				}
			}
			return index;
		} else {
			throw new NullPointerException();
		}
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
		this.size++;
	}

	public void addLast(E e) {
		addLastNode(new Node<E>(e));
	}

	private void addLastNode(Node<E> newNode){
		if (size == 0)
			head = tail = newNode;
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		this.size++;
	}

	public void add(E e){
		if (e != null)
			addLastNode(new Node<E>(e));
		else
			throw new NullPointerException();
	}

	/**
	 * Inserts the specified element at the specified position in this DS.
	 * @param index
	 * @param element
	 */
	public void add(int index, E element){
		if (element != null){
			checkBoundsInclusive(index);
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
				addLastNode(newNode);
		} else
			throw new NullPointerException();

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

		Node<E> after;
		Node<E> before;

		if (index != this.size){
			if(VERBOSE_ADDALL2) System.out.println("Get node for before");
			before = getNode(index);
			if(VERBOSE_ADDALL2) System.out.println("Got the Node");
			after = before.prev;
		} else {
			before = null;
			after = tail;
		}

		if(VERBOSE_ADDALL2){
			System.out.println("Value of Before => " + before.data);
			System.out.println("Value of After => " + after.data);
		}

		Object[] o = c.toArray();
		Object[] ro = new Object[o.length];
		int x = 0;
		for (int y = 0; y < o.length; y++){
			if ((E)o[y] != null){
				ro[x] = (E)o[y];
				x++;
			}
		}
		Object[] on = new Object[x];
		for(int y = 0; y < on.length; y++){
			on[y] = ro[y];
		}

		csize = on.length;

		Node<E> newHead = null;
		Node<E> newTail = null;
		Node<E> previousNode = after;
		for (int pos = 0; pos < csize; pos++){

			Node<E> newNode = new Node<E>((E)on[pos]);

			previousNode.next = newNode;
			newNode.prev = previousNode;
			previousNode = newNode;
			if (pos == 0)
				newHead = newNode;

			if (pos == csize - 1)
				newTail = newNode;
		}

		if (VERBOSE_ADDALL1) System.out.println("Size before resize = " + this.size);
		this.size += csize;
		if (VERBOSE_ADDALL1) System.out.println("Size after resize = " + this.size);


		if (before != null){
			newTail.next = before;
			before.prev = newTail;
		} else {
			tail = newTail;
		}

		if (after != null) {
			newHead.prev = after;
			after.next = newHead;
		} else {
			head = newHead;
		}

		return true;
	}

	/**
	 * Removes the first occurrence of the specified element from this DS,
	 * if it is present.
	 * @param o
	 * @return
	 */
	public void remove(Object o) {
		if (o != null){
			Node<E> currentNode = head;
			while(currentNode != null){

				if (currentNode.data != null){

					if (currentNode.data.equals(o)){
						removeNode(currentNode);
					}

					currentNode = currentNode.next;
				} else {
					break;
				}
			}
		} else {
			throw new NullPointerException();
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
		if (element != null){
			Node<E> newNode = getNode(index);
			E old = newNode.data;
			newNode.data = element;
		} else
			throw new NullPointerException();
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
		if (size > 0){
			head = null;
			tail = null;
			this.size = 0;
		}
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
	 * Removes from this DS all of its elements that are contained in the
	 * specified collection.
	 * @param c
	 * @return
	 */
	public void removeAll(Collection<?> c){
		for (Object o : c){
			if (o != null){
				Node<E> currentNode = head;

				while (currentNode != null){
					if (currentNode.data != null){
						if (currentNode.data.equals(o)){
							removeNode(currentNode);
						}

						currentNode = currentNode.next;
					} else {
						break;
					}
				}
			} else {
				throw new NullPointerException();
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
		Node<E> currentNode = head;
		while (currentNode != null){
			boolean isCurrentNodePresentAtCollection = false;

			for (Object o : c){
				if (o != null){
					if (currentNode.data != null){
						if (currentNode.data.equals(o)){
							isCurrentNodePresentAtCollection = true;
							if (!isCurrentNodePresentAtCollection){
								removeNode(currentNode);
								isCurrentNodePresentAtCollection = false;
							}
						}
					}
				} else
					throw new NullPointerException();
			}

			currentNode = currentNode.next;
		}
	}

	/**
	 * Returns true if this DS contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		if (o != null){
			Node<E> currentNode = head;
			while (currentNode != null){
				if (VERBOSE_CONTAINSALL1) System.out.println("Analyzing value => " + currentNode.data);

				if (currentNode.data != null){
					if (VERBOSE_CONTAINSALL1) System.out.println("Value isn't null !");

					if (currentNode.data.equals(o)){
						if (VERBOSE_CONTAINSALL1) System.out.println("Value is in Collection !!");

						return true;
					}

					currentNode = currentNode.next;
				} else {
					if (VERBOSE_CONTAINSALL1) System.out.println("Value is null !");
					break;
				}
			}

		} else {
			throw new NullPointerException();
		}
		return false;
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
			if (o != null){
				if (VERBOSE_CONTAINSALL1) System.out.println("Value entered is => " + o);
				boolean isNumberInLinkedList = contains(o);
				if (isNumberInLinkedList)
					numbersEqualToCollection++;
			} else
				throw new NullPointerException();

		}
		if (VERBOSE_CONTAINSALL1) System.out.println("Size of Collection VS NumbersContained [" + csize + "][" + numbersEqualToCollection + "]");
		return csize == numbersEqualToCollection;
	}

	/**
	 * Returns the number of elements in this DS.
	 * @return
	 */
	public int size() {
		return size;
	}
}
