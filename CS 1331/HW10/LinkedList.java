//I worked on the homework assignment alone, using only course materials

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
*This class represents LinkedList.
*@param <T> the Nodes that are used in the LinkedList
*@author Owen Huggins
*@version 1.0
*/

public class LinkedList<T> {



    private Node<T> head;
    private int size;

    /**
    *A constructor for LinkedList that initalizes a LinkedList
    */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    /**
    *A method that adds a node to the list at a specific index
    *@param data the data in the node
    *@param index where the node is going to go
    */

    public void addAtIndex(T data, int index) {
        if (index < 0 || index > (this.size + 1)) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            head = new Node<T>(data, head);
            this.size++;
        } else {
            int counter = 0;
            Node<T> current = head;
            Node<T> holder = new Node<T>(data, null);
            while (current != null) {
                if (index - 1 == counter) {
                    holder.setNext(current.getNext());
                    current.setNext(holder);
                    this.size++;
                    return;
                } else {
                    counter++;
                    current = current.getNext();
                }
            }
        }
    }

    /**
    *A method that removes a node from the index and returns it to the user
    *@param index where the data is removed from
    *@return tempData the data from the removed node
    */

    public T removeFromIndex(int index) {
        Node<T> current = head;
        T tempData;

        if (this.isEmpty() || index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            tempData = head.getData();
            head = current.getNext();
            return tempData;
        } else {
            int counter = 0;
            while (current != null) {
                if (counter == (index - 1)) {
                    Node<T> prev = current;
                    Node<T> tempNode = current.getNext();
                    tempData = tempNode.getData();
                    prev.setNext(tempNode.getNext());
                    current.setNext(current.getNext());
                    this.size = this.size - 1;
                    return tempData;
                } else {
                    counter++;
                    current = current.getNext();
                }
            }


        }
        return null;
    }

    /**
    *A method that returns the data from a node
    *@param index where the data is collected
    *@return the data from the node
    */

    public T get(int index) {

        if (this.isEmpty() || index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        Node<T> current = head;
        if (index == 0) {
            return head.getData();
        } else {
            while (current != null) {
                if (counter == index) {
                    return current.getData();
                }
                counter++;
                current = current.getNext();
            }
            return null;
        }
    }

    /**
    *A method that checks if the LinkedList is empty
    *@return boolean whether or not the list is empty
    */

    public boolean isEmpty() {
        return (head == null);
    }

    /**
    *A method that clears the LinkedList
    */

    public void clear() {
        head = null;
        this.size = 0;
    }

    /**
    *A method that moves a node to the front of the list
    *@param data the data in a specific node that will be moved
    */

    public void toTheFront(T data) {
        T lastData;
        Node<T> holder = new Node<T>(data, null);
        if (data == (head.getData())) {
            head = head;
        } else if (head.getNext() == null) {
            head = new Node<T>(data, head);
            return;
        } else {
            Node<T> current = head;
            boolean found = false;
            while ((current.getNext() != null) && (!found)) {
                if (data == (current.getNext().getData())) {
                    head = new Node<T>(data, head);
                    Node<T> prev = current;
                    Node<T> tempNode = current.getNext();
                    prev.setNext(tempNode.getNext());
                    current.setNext(current.getNext());
                    found = true;
                    return;
                } else {
                    current = current.getNext();
                }
            }

            throw new NoSuchElementException();
        }
    }

    /**
    *A method converts the LinkedList into an array list and then returns it
    *@return arrayList the newly created arrayList
    */

    public ArrayList<T> toArrayList() {
        Node<T> current = head;
        ArrayList<T> arrayList = new ArrayList<>();
        while (current != null) {
            arrayList.add(current.getData());
            current = current.getNext();
        }
        return arrayList;
    }

    /**
    *A method that returns the middle element in the LinkedList
    *@return the data from the middle element
    */

    public T accessMiddle() {
        Node<T> current = head;
        int index = 1;
        int counter = 0;
        while (current != null) {
            index++;
            current = (current.getNext());
        }
        current = head;
        while (current != null) {
            if ((((int) (index / 2)) - 1) == (counter)) {
                return current.getData();
            } else {
                counter++;
                current = current.getNext();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList <String> tester = new LinkedList();
        tester.addAtIndex("1", 0);
        tester.addAtIndex("2", 1);
        tester.addAtIndex("3", 2);
        tester.addAtIndex("4", 3);
        System.out.println(tester.toArrayList());
        tester.addAtIndex("I'm now the front", 0);
        System.out.println(tester.toArrayList());
    }


}
