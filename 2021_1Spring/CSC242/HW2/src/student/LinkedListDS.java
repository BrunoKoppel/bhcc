package student;

import java.util.Collection;


public class LinkedListDS<E> {

	boolean VERBOSE_ADD1 = false;
	boolean VERBOSE_ADD2 = false;
	boolean VERBOSE_ADDALL1 = false;
	boolean VERBOSE_ADDALL2 = false;
	boolean VERBOSE_CLEAR = false;
	boolean VERBOSE_CONTAINS1 = false;
	boolean VERBOSE_CONTAINS2 = false;
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

	public class Node<E>{
		E dataValue;
		Node nextNode;
		Node prevNode;

		Node(){}

		Node(E e){
			dataValue = e;
		}

		Node(E e, Node next, Node prev){
			this.dataValue = e;
			this.prevNode = prev;
			this.nextNode = next;
		}
	}


	/**
	 * Appends the specified element to the end of this DS.
	 * @param e
	 */
	public void	add(E e){
		if (VERBOSE_ADD1) System.out.println("Entering value => " + e);

		if (head != null){
			Node last = head;
			while (last.dataValue != null){
				if (VERBOSE_ADD1) System.out.println("Skipping Node => " + last.dataValue);
				last = last.nextNode;
			}

			last = new Node(e, null, last.prevNode);
			tail = last;
			if (VERBOSE_ADD1) System.out.println("Storing at Node => " + last.dataValue);
		} else {
			head = new Node(e, null, null);
			tail = head;
		}
	}

	/**
	 * Inserts the specified element at the specified position in this DS.
	 * @param index
	 * @param element
	 */
	public void add(int index, E element){
		if (index > this.size()){
			throw new IndexOutOfBoundsException();
		} else if (index < 1){
			throw new IndexOutOfBoundsException();
		} else {
			if (index == 1){
				if (VERBOSE_ADD2) System.out.println("Entering value => " + element + " at node [" + 1  + "]");
				Node head = new Node(element, null, null);;
				tail = head;
			} else {
				int current = 1;
				Node last = head;
				while (current < index){
					if (VERBOSE_ADD2) System.out.println("At Node => " + last.dataValue + " moving towards Node => " + last.dataValue);
					last = last.nextNode;
					current++;
				}

				if (VERBOSE_ADD2) System.out.println("Entering value => " + element + " at node [" + current  + "]");
				last = new Node(element, last.nextNode, last.prevNode);
				tail = last.nextNode;
			}


		}
	}

	/**
	 * Appends all of the elements in the specified collection to the end of
	 * this DS, in the order that they are held by the specified collection.
	 * @param c
	 * @return
	 */
	public void addAll(Collection<? extends E> c){
		for (E object : c){
			if (VERBOSE_ADDALL1) System.out.println("Entering value: " + object);

			if (head == null){
				head.dataValue = object;
			} else {
				Node last = head;
				while (last.nextNode != null){
					if (VERBOSE_ADDALL1) System.out.println("Skipping Node = " + tail.dataValue);
					last = last.nextNode;
				}

				last.nextNode.dataValue = object;
				last.nextNode.prevNode = last;
				if (VERBOSE_ADDALL1) System.out.println("Storing After Node = " + tail.nextNode.dataValue);
			}
		}
	}

	/**
	 * Inserts all of the elements in the specified collection into this list
	 * at the specified position.
	 * @param index
	 * @param c
	 * @return
	 */
	public void addAll(int index, Collection<? extends E> c){
		if (index-1 > this.size()){
			throw new IndexOutOfBoundsException();
		} else {
			boolean endOfList = (index -1 == this.size());
			int current = 1;
			Node last = head;
			while (current < index){
				if (VERBOSE_ADDALL2) System.out.println("Currently at Node => " + current + " out of " + index + " Nodes");

				if (last.nextNode != null){
					last = last.nextNode;
					current++;
				}
			}

			for (E o : c){

				if (VERBOSE_ADDALL2) {
					System.out.println("Entering value: " + o);
					System.out.println("Currently at Node : " + last.dataValue);
				}

			}
		}
	}

	/**
	 * Removes all of the elements from this DS.
	 */
	public void clear(){
		Node jumper = head;
		head = null;

		while(jumper.nextNode != null){
			if (VERBOSE_CLEAR) System.out.println("Clearing the List at index => " + jumper.dataValue);
			jumper = jumper.nextNode;
			Node last = jumper;
			last = null;
		}
	}

	/**
	 * Returns true if this DS contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		Node last = head;
		if (head == null){
			return false;
		} else {
			while (last.nextNode != null){
				if(last.dataValue == o){
					return true;
				}
				last = last.nextNode;
			}
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
		if (head == null){
			return false;
		}

		int similarValues = 0;
		int size = c.size();
		Node last = head;

		for (Object object : c){
			while (last.nextNode != null){
				if(last.dataValue == object){
					similarValues ++;
					break;
				}
			}
		}

		return similarValues == size;
	}


	/**
	 * Returns the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	public E get(int index){
		if (VERBOSE_GET1) System.out.println("Returning Value at Index = " + index);
		if (index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		int current = 1;
		Node last = head;
		if (VERBOSE_GET1) System.out.println("At Node = " + current);
		while (current < index){
			if (VERBOSE_GET1) System.out.println("At Node = " + current);
			if (last.nextNode == null){
				return null;
			} else {
				last = last.nextNode;
				current++;
			}
		}

		return (E) last.dataValue;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this DS, or -1 if this list does not contain the element.
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		if (VERBOSE_GET2) System.out.println("Returning Index of object = " + (E) o);
		int current = 0;
		Node last = head;
		boolean isObjectFound = false;
		boolean endOfList = false;
		while (!isObjectFound || !endOfList){
			if (VERBOSE_GET2) System.out.println("At Node = " + current);
			isObjectFound = (last.dataValue == (E) o);
			endOfList = (last.nextNode == null);
			last = last.nextNode;
			current++;
		}
		return current;
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}

	/**
	 * Removes the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	 public E remove(int index){
		 if (VERBOSE_REMOVE1) System.out.println("Removing Value at Index = " + index);
		 int current = 1;
		 Node last = head;
		 if (VERBOSE_REMOVE1) System.out.println("At Node = " + current);
		 while (current < index){
			 if (VERBOSE_REMOVE1) System.out.println("At Node = " + current);
			 if (last.nextNode == null){
				 Node dummyNode = new Node();
				 last.nextNode = dummyNode;
			 }
			 last = last.nextNode;
			 current++;
		 }

		 E data = (E) last.dataValue;
		 last.dataValue = null;
		 last.prevNode = last.nextNode;
		 return data;
	 }

	/**
	 * Removes the first occurrence of the specified element from this DS,
	 * if it is present.
	 * @param o
	 * @return
	 */
	public void remove(Object o){
		if (VERBOSE_REMOVE2) System.out.println("Removing Object = " + (E)o);
		int current = 0;

		Node last = head;
		boolean isObjectFound = false;
		boolean endOfList = false;
		while (!isObjectFound || !endOfList){
			if (VERBOSE_REMOVE2) System.out.println("At Node = " + current);
			isObjectFound = (last.dataValue == (E)o);
			if(isObjectFound){
				if (VERBOSE_REMOVE2) System.out.println("Object found and removed");
				last.dataValue = null;
				last = null;
			}

			endOfList = (last.nextNode == null);
			last = last.nextNode;
			current++;
		}
	}

	/**
	 * Removes from this DS all of its elements that are contained in the
	 * specified collection.
	 * @param c
	 * @return
	 */
	public void	removeAll(Collection<?> c){
		for (Object o : c){
			if (VERBOSE_REMOVE3) System.out.println("Removing Object = " + (E)o);
			int current = 0;
			Node last = head;
			boolean isObjectFound = false;
			boolean endOfList = false;

			while (!isObjectFound || !endOfList){
				if (VERBOSE_REMOVE3) System.out.println("At Node = " + current);
				isObjectFound = (last.dataValue == (E) o);
				if(isObjectFound){
					if (VERBOSE_REMOVE3) System.out.println("Object found and removed");
					last.dataValue = null;
					last = null;
					last.prevNode.nextNode = last.nextNode;
					last.nextNode.prevNode = last.prevNode;
				}

				endOfList = (last.nextNode == null);
				if (VERBOSE_REMOVE3 && endOfList) System.out.println("End of List Reached");
				last = last.nextNode;
				current++;
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
	 	Node last = head;

	 	if (head != null){
			do {
				boolean isNodeOnCollection = false;

				for (Object o : c){
					isNodeOnCollection = (o == last.dataValue);
				}

				if (isNodeOnCollection){
					last.dataValue = null;
					last.prevNode.nextNode = last.nextNode;
					last.nextNode.prevNode = last.prevNode;
				}
			} while (last.nextNode != null);
		}

	 }

	/**
	 * Replaces the element at the specified position in this DS with the
	 * specified element.
	 * @param index
	 * @param element
	 * @return
	 */
	public void set(int index, E element){
		if (VERBOSE_SET)	System.out.println("");
		int current = 0;
		Node dummyNode = new Node();
		Node newNode = new Node(element);
		Node last = head;
		while (current < index - 1){
			last = last.nextNode;
			if (VERBOSE_SET) System.out.println("At Node = " + current);
			if (last.nextNode == null){
				last.nextNode = dummyNode;
			}
			current++;
		}
		newNode.nextNode = last.nextNode.nextNode;
		newNode.prevNode = last;
		last.nextNode = newNode;
	}

	/**
	 * Returns the number of elements in this DS.
	 * @return
	 */
	public int size() {
		int size = 0;
		Node last = head;
		do {
			if (last != null){
				if (VERBOSE_SIZE) System.out.println("Currently at node = " + last.dataValue);
				size++;
				last = last.nextNode;
			}
		} while (last != null);

		if (VERBOSE_SIZE) System.out.println("Size of => " + size);
		return size;
	}
}
