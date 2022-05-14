import java.util.ArrayList;

/**
 * Your implementation of a MinHeap.
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
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap when created with the default
     * constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    // Do not add new instance variables or modify existing ones.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new MinHeap.
     *
     * The backing array should have an initial capacity of INITIAL_CAPACITY.
     */
    public MinHeap() {
        this.size = 0;
        this.backingArray = (T[]) new Comparable[INITIAL_CAPACITY];

    }

    /**
     * Creates a properly ordered heap from a set of initial values.
     *
     * You must use the BuildHeap algorithm that was taught in lecture! Simply
     * adding the data one by one using the add method will not get any credit.
     * As a reminder, this is the algorithm that involves building the heap
     * from the bottom up by repeated use of downHeap operations.
     *
     * Before doing the algorithm, first copy over the data from the
     * ArrayList to the backingArray (leaving index 0 of the backingArray
     * empty). The data in the backingArray should be in the same order as it
     * appears in the passed in ArrayList before you start the BuildHeap
     * algorithm.
     *
     * The backingArray should have capacity 2n + 1 where n is the
     * number of data in the passed in ArrayList (not INITIAL_CAPACITY).
     * Index 0 should remain empty, indices 1 to n should contain the data in
     * proper order, and the rest of the indices should be empty.
     *
     * @param data a list of data to initialize the heap with
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public MinHeap(ArrayList<T> data) {
        if (data == null || data.contains(null)) {
            throw new java.lang.IllegalArgumentException("Data in the array cannot be null");
        } else {
            this.size = data.size();
            this.backingArray = (T[]) new Comparable[this.size * 2 + 1];


            for (int i = 1; i <= this.size; i++) {
                this.backingArray[i] = data.get(i - 1);

            }

            this.backingArray = downHeap(this.backingArray, this.size / 2);
        }


    }



    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     * The order property of the heap must be maintained after adding.
     * 
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        this.size++;
        if (this.size >= this.backingArray.length) {
            T[] temp = (T[]) new Comparable[(this.backingArray.length * 2)];
            for (int i = 1; i < this.size; i++) {
                temp[i] = this.backingArray[i];
            }
            this.backingArray = temp;
        }
        this.backingArray[this.size] = data;

        this.backingArray = downHeap(this.backingArray, this.size / 2);


    }

    /**
     * A helper method for the down heap algorithm
     *
     * @param data the unsorted Arraylist to put in correct order
     * @param index the starting point of where we are down heaping
     * @return the correct values for the array
     */

    private T[] downHeap(T[] data, int index) {
        if (index == 0 || this.size == 1) {
            return data;
        }
        if (index * 2 == this.size) {
            if (data[index].compareTo(data[index * 2]) > 0) {
                T copy = data[index];
                data[index] = data[index * 2];
                data[index * 2] = copy;
            }
            return downHeap(data, index - 1);
        } else {
            if (data[index].compareTo(data[index * 2]) < 0
                    && data[index].compareTo(data[index * 2 + 1]) < 0) {
                return (downHeap(data, index - 1));
            }
            T copy = data[index];
            if (data[index].compareTo(data[index * 2]) > 0
                    && data[index].compareTo(data[index * 2 + 1]) < 0) {
                data[index] = data[index * 2];
                data[index * 2] = copy;
                if ((index * 2) * 2 + 1 <= this.size) {
                    return (downHeap(data, index * 2));
                }

            } else if (data[index].compareTo(data[index * 2]) < 0
                    && data[index].compareTo(data[index * 2 + 1]) > 0) {
                data[index] = data[index * 2 + 1];
                data[index * 2 + 1] = copy;
                if ((index * 2 + 1) * 2 + 1 < this.size) {
                    return (downHeap(data, index * 2 + 1));
                }
            } else {
                if (data[index * 2].compareTo(data[index * 2 + 1]) < 0) {
                    data[index] = data[index * 2];
                    data[index * 2] = copy;
                    if ((index * 2) * 2 + 1 <= this.size) {
                        return (downHeap(data, index * 2));
                    }
                } else {
                    data[index] = data[index * 2 + 1];
                    data[index * 2 + 1] = copy;
                    if ((index * 2) * 2 + 1 < this.size) {
                        return (downHeap(data, index * 2 + 1));
                    }
                }

            }
            return (downHeap(data, index));

        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     * The order property of the heap must be maintained after adding.
     *
     * @return the data that was removed
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T remove() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("The heap is already empty");
        } else {
            System.out.println(this.size);
            T copy = this.backingArray[1];
            this.backingArray[1] = this.backingArray[this.size];
            this.backingArray[this.size] = null;
            this.size--;
            if (this.size == 0 || this.size == 1) {
                return copy;
            }

            this.backingArray = upHeap(this.backingArray, 1);
            return copy;
        }
    }

    /**
     * A helper method for the down heap algorithm
     *
     * @param data the unsorted Arraylist to put in correct order
     * @param index the starting point of where we are down heaping
     * @return the newly updated backingArray
     */

    private T[] upHeap(T[] data, int index) {
        if (index == 1 && (this.size == 2 || this.size == 3)) {
            T copy = data[index];
            if (this.size == 3) {
                if (data[index * 2].compareTo(data[index * 2 + 1]) < 0) {
                    data[index] = data[index * 2];
                    data[index * 2] = copy;
                } else {
                    data[index] = data[index * 2 + 1];
                    data[index * 2 + 1] = copy;
                }
            } else {
                if (data[index].compareTo(data[index * 2]) > 0) {
                    data[index] = data[index * 2];
                    data[index * 2] = copy;
                }
            }
            return data;
        }
        if (index >= this.size / 2) {
            return data;
        } else {
            if (data[index].compareTo(data[index * 2]) < 0
                    && data[index].compareTo(data[index * 2 + 1]) < 0) {
                return upHeap(data, index + 1);
            }
            T copy = data[index];
            if (data[index].compareTo(data[index * 2]) > 0
                    && data[index].compareTo(data[index * 2 + 1]) < 0) {
                data[index] = data[index * 2];
                data[index * 2] = copy;


            } else if (data[index].compareTo(data[index * 2]) < 0
                    && data[index].compareTo(data[index * 2 + 1]) > 0) {
                data[index] = data[index * 2 + 1];
                data[index * 2 + 1] = copy;

            } else {
                if (data[index * 2].compareTo(data[index * 2 + 1]) < 0) {
                    data[index] = data[index * 2];
                    data[index * 2] = copy;
                } else {
                    data[index] = data[index * 2 + 1];
                    data[index * 2 + 1] = copy;
                }

            }
            return upHeap(data, index + 1);
        }

    }



    /**
     * Returns the minimum element in the heap.
     *
     * @return the minimum element
     * @throws java.util.NoSuchElementException if the heap is empty
     */
    public T getMin() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("The heap is empty");
        }
        return this.backingArray[1];
    }

    /**
     * Returns whether or not the heap is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return this.backingArray[1] == null;

    }

    /**
     * Clears the heap.
     *
     * Resets the backing array to a new array of the initial capacity and
     * resets the size.
     */
    public void clear() {
        this.backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
