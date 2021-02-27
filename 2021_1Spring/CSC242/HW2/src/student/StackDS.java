package student;

import java.util.Collection;

public class StackDS<E> {


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

	public StackDS(){

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

	private void checkBoundsInclusive(int index){
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	private void checkBoundsExclusive(int index){
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	/**
	 * Appends the specified element to the end of this DS.
	 * @param e
	 */
	public void	add(E e){
		addLastNode(new Node<E>(e));
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
	 * Appends all of the elements in the specified collection to the end of 
	 * this DS, in the order that they are held by the specified collection.
	 * @param c
	 * @return
	 */
	public void addAll(Collection<? extends E> c){

	}

	/**
	 * Inserts all of the elements in the specified collection into this list 
	 * at the specified position.
	 * @param index
	 * @param c
	 * @return
	 */
	public void addAll(int index, Collection<? extends E> c){

	}

	/**
	 * Removes all of the elements from this DS.
	 */
	public void clear(){

	}

	/**
	 * Returns true if this DS contains the specified element.
	 * @param o
	 * @return
	 */
	public boolean contains(Object o){
		return this.contains(o);
	}

	/**
	 * Returns true if this list contains all of the elements of the specified
	 * collection.
	 * @param c
	 * @return
	 */
	public boolean containsAll(Collection<?> c){
		return containsAll(c);
	}


	/**
	 * Returns the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	public E get(int index){
		return getNode(index).data;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in 
	 * this DS, or -1 if this list does not contain the element.
	 * @param o
	 * @return
	 */
	public int indexOf(Object o){
		return this.indexOf(o);
	}

	/**
	 * Returns true if this list contains no elements.
	 * @return
	 */
	public boolean	isEmpty(){
		return this.isEmpty();
	}

	/**
	 * Removes the element at the specified position in this DS.
	 * @param index
	 * @return
	 */
	 public E remove(int index){
	 	return this.remove(index);
	 }

	/**
	 * Removes the first occurrence of the specified element from this DS, 
	 * if it is present.
	 * @param o
	 * @return
	 */
	public void remove(Object o){

	}

	/**
	 * Removes from this DS all of its elements that are contained in the 
	 * specified collection.
	 * @param c
	 * @return
	 */
	public void	removeAll(Collection<?> c){

	}

	/**
	 * Retains only the elements in this DS that are contained in the specified
	 * collection.
	 * @param c
	 * @return
	 */
	 public void retainAll(Collection<?> c){
	 	this.retainAll(c);
	 }

	/**
	 * Replaces the element at the specified position in this DS with the 
	 * specified element.
	 * @param index
	 * @param element
	 * @return
	 */
	public void set(int index, E element){

	}

	/**
	 * Returns the number of elements in this DS.
	 * @return
	 */
	public int	size(){
		return this.size();
	}
	
	/**
	 * You only need to implement this function if this is Queue or a Stack else throw 
	 * UnsupportedOperationException 
	 * <br>
	 * <br>
	 * <b>Queue:</b>
	 * Retrieves, but does not remove, the head of this queue, or returns null if this 
	 * queue is empty.
	 * <br>
	 * <br>
	 * <b>Stack:</b>
	 * Looks at the object at the top of this stack without removing it from the stack.
	 */
	public E peek(){
		return this.peek();
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue 
	 * is empty.
	 * 
	 * You only need to implement this function if this is Queue else throw 
	 * UnsupportedOperationException 
	 * @return
	 */
	public E poll() {
		return this.poll();
	}
	
	/**
	 * You only need to implement this function if this is Queue or Stack else throw 
	 * UnsupportedOperationException 
	 * 
	 * Retrieves and removes the head of this queue or the top of the stack.
	 */
	public E remove(){
		return this.remove();
	}
	
	/**
	 * You only need to implement this function if this is Stack else throw 
	 * UnsupportedOperationException 
	 * 
	 * Removes the object at the top of this stack and returns that object as the 
	 * value of this function.
	 * @return
	 */
	public E pop(){
		return this.pop();
	}
	
	/**
	 * You only need to implement this function if this is Stack else throw 
	 * UnsupportedOperationException 
	 * 
	 * Pushes an item onto the top of this stack.
	 * @param item
	 */
	public void push(E item){

	}
}
