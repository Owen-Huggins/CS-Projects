/**
 * Your implementation of a LinkedDeque.
 *
 * @author YOUR NAME HERE
 * @version 1.0
 * @userid ohuggins3
 * @GTID 903591787
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class LinkedDeque<T> {

    // Do not add new instance variables or modify existing ones.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    // Do not add a constructor.

    /**
     * Adds the element to the front of the deque.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addFirst(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        if (size == 0) {
            head = new LinkedNode<T>(data);
            tail = head;
            size++;
        } else {
            LinkedNode<T> holder = new LinkedNode<T>(data);
            holder.setNext(head);
            head.setPrevious(holder);
            head = holder;
            size++;
        }

    }

    /**
     * Adds the element to the back of the deque.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the deque
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addLast(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        if (size == 0) {
            head = new LinkedNode<T>(data);
            tail = head;
            size++;
        } else {
            LinkedNode<T> holder = new LinkedNode<T>(data);
            tail.setNext(holder);
            holder.setPrevious(tail);
            tail = holder;
            size++;
        }

    }

    /**
     * Removes and returns the first element of the deque.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeFirst() {
        if (head == null && tail == null) {
            throw new java.util.NoSuchElementException("Deque is Empty");

        } else if (size == 1) {
            LinkedNode<T> holder = head;
            head = null;
            tail = null;
            size = 0;
            return holder.getData();
        } else {
            LinkedNode<T> holder = head;
            head = head.getNext();
            head.getPrevious().setNext(null);
            head.setPrevious(null);
            size--;
            return holder.getData();
        }

    }

    /**
     * Removes and returns the last element of the deque.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the back of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T removeLast() {
        if (head == null && tail == null) {
            throw new java.util.NoSuchElementException("Deque is empty");
        }
        if (size == 1) {
            LinkedNode<T> holder = head;
            head = null;
            tail = null;
            size = 0;
            return holder.getData();
        } else {
            LinkedNode<T> holder = tail;
            tail = tail.getPrevious();
            tail.getNext().setPrevious(null);
            tail.setNext(null);
            size--;
            return holder.getData();
        }

    }

    /**
     * Returns the first data of the deque without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the front of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T getFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("Deque is empty");
        } else {
            return head.getData();
        }

    }

    /**
     * Returns the last data of the deque without removing it.
     *
     * Must be O(1).
     *
     * @return the data located at the back of the deque
     * @throws java.util.NoSuchElementException if the deque is empty
     */
    public T getLast() {
        if (tail == null) {
            throw new java.util.NoSuchElementException("Deque is empty");
        } else {
            return tail.getData();
        }

    }

    /**
     * Returns the head node of the deque.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return node at the head of the deque
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the deque.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return node at the head of the deque
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the deque.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the deque
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
