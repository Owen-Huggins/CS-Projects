/**
 * Your implementation of a non-circular DoublyLinkedList with a tail pointer.
 *
 * @author Owen Huggins
 * @version 1.0
 * @userid ohuggins3
 * @GTID 903591787
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */
public class DoublyLinkedList<T> {

    // Do not add new instance variables or modify existing ones.
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    // Do not add a constructor.

    /**
     * Adds the element to the specified index. Don't forget to consider whether
     * traversing the list from the head or tail is more efficient!
     *
     * Must be O(1) for indices 0 and size and O(n) for all other cases.
     *
     * @param index the index at which to add the new element
     * @param data  the data to add at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index > size
     * @throws java.lang.IllegalArgumentException  if data is null
     */
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new java.lang.IndexOutOfBoundsException();
        } else if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (index == 0) {
            addToFront(data);
        }
        if (index == size) {
            addToBack(data);
        } else {
            if (index > (size / 2)) {
                int counter = size - 1;
                DoublyLinkedListNode<T> current = tail;
                DoublyLinkedListNode<T> holder = new DoublyLinkedListNode<T>(data);
                while (current != null) {
                    if (index == counter) {
                        current.getPrevious().setNext(holder);
                        holder.setPrevious(current.getPrevious());
                        holder.setNext(current);
                        current.setPrevious(holder);
                        size++;
                        return;
                    }
                    counter--;
                    current = current.getPrevious();
                }
            } else {
                int counter = 0;
                DoublyLinkedListNode<T> current = head;
                DoublyLinkedListNode<T> holder = new DoublyLinkedListNode<T>(data);
                while (current != null) {
                    if (index - 1 == counter) {
                        current.getNext().setPrevious(holder);
                        holder.setNext(current.getNext());
                        current.setNext(holder);
                        holder.setPrevious(current);
                        size++;
                        return;
                    } else {
                        counter++;
                        current = current.getNext();
                    }
                }
            }
        }
    }

    /**
     * Adds the element to the front of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (size == 0) {
            head = new DoublyLinkedListNode<T>(data);
            tail = head;
            size++;
        } else {
            DoublyLinkedListNode<T> holder = new DoublyLinkedListNode<T>(data);
            holder.setNext(head);
            head.setPrevious(holder);
            head = holder;
            size++;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Must be O(1).
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (size == 0) {
            head = new DoublyLinkedListNode<T>(data);
            tail = head;
            size++;
        } else {
            DoublyLinkedListNode<T> holder = new DoublyLinkedListNode<T>(data);
            tail.setNext(holder);
            holder.setPrevious(tail);
            tail = holder;
            size++;
        }
    }

    /**
     * Removes and returns the element at the specified index. Don't forget to
     * consider whether traversing the list from the head or tail is more
     * efficient!
     *
     * Must be O(1) for indices 0 and size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to remove
     * @return the data formerly located at the specified index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFromFront();
        } else if (index == size - 1) {
            removeFromBack();
        } else {
            if (index >= (size / 2)) {
                int counter = size - 1;
                DoublyLinkedListNode<T> current = tail;
                while (current != null) {
                    if (index == counter) {
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                        size--;
                        return current.getData();
                    }
                    counter--;
                    current = current.getPrevious();
                }
                return null;
            } else {
                int counter = 0;
                DoublyLinkedListNode<T> current = head;
                DoublyLinkedListNode<T> holder;
                while (current.getNext() != null) {
                    if (index - 1 == counter) {
                        holder = current.getNext();
                        current.setNext(holder.getNext());
                        holder.getNext().setPrevious(current);
                        size--;
                        return holder.getData();
                    } else {
                        counter++;
                        current = current.getNext();
                    }
                }
            }

        }
        return null;

    }

    /**
     * Removes and returns the first element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();

        } else if (size == 1) {
            DoublyLinkedListNode<T> holder = head;
            clear();
            return holder.getData();
        } else {
            DoublyLinkedListNode<T> holder = head;
            head = head.getNext();
            head.getPrevious().setNext(null);
            head.setPrevious(null);
            size--;
            return holder.getData();
        }
    }

    /**
     * Removes and returns the last element of the list.
     *
     * Must be O(1).
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        if (size == 1) {
            DoublyLinkedListNode<T> holder = tail;
            clear();
            return holder.getData();
        } else {
            DoublyLinkedListNode<T> holder = tail;
            tail = tail.getPrevious();
            tail.getNext().setPrevious(null);
            tail.setNext(null);
            size--;
            return holder.getData();
        }
    }

    /**
     * Returns the element at the specified index. Don't forget to consider
     * whether traversing the list from the head or tail is more efficient!
     *
     * Must be O(1) for indices 0 and size - 1 and O(n) for all other cases.
     *
     * @param index the index of the element to get
     * @return the data stored at the index in the list
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or index >= size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.getData();
        } else if (index == size - 1) {
            return tail.getData();
        } else {
            if (index > (size / 2)) {
                int counter = size - 1;
                DoublyLinkedListNode<T> current = tail;
                while (current.getPrevious() != null) {
                    if (counter == index) {
                        return current.getData();
                    }
                    counter--;
                    current = current.getPrevious();
                }
                return null;
            } else {
                int counter = 0;
                DoublyLinkedListNode<T> current = head;
                while (current.getNext() != null) {
                    if (counter == index) {
                        return current.getData();
                    }
                    counter++;
                    current = current.getNext();
                }
                return null;
            }
        }

    }

    /**
     * Returns whether or not the list is empty.
     *
     * Must be O(1).
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Clears the list.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Removes and returns the last copy of the given data from the list.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the list.
     *
     * Must be O(1) if data is in the tail and O(n) for all other cases.
     *
     * @param data the data to be removed from the list
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if data is not found
     */
    public T removeLastOccurrence(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else if  (size == 1) {
            if (head.getData() == data) {
                return removeFromFront();
            } else {
                throw new java.util.NoSuchElementException();
            }
        } else if (tail.getData() == data) {
            return removeFromBack();
        } else {
            DoublyLinkedListNode<T> current = tail;
            while (current.getPrevious() != null) {
                if (current.getData() == data) {
                    DoublyLinkedListNode<T> holder = current;
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                    return holder.getData();
                }
                current = current.getPrevious();
            }

            throw new java.util.NoSuchElementException();

        }


    }

    /**
     * Returns an array representation of the linked list. If the list is
     * size 0, return an empty array.
     *
     * Must be O(n) for all cases.
     *
     * @return an array of length size holding all of the objects in the
     * list in the same order
     */
    public Object[] toArray() {
        if (size == 0) {
            Object[] anArray = new Object[size];
            return anArray;
        } else {
            DoublyLinkedListNode<T> current = head;
            Object[] anArray = new Object[size];
            int counter = 0;
            while (current != null) {
                anArray[counter] = current.getData();
                counter++;
                current = current.getNext();
            }
            return anArray;
        }

    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public DoublyLinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public DoublyLinkedListNode<T> getTail() {
        // DO NOT MODIFY!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY!
        return size;
    }
}
