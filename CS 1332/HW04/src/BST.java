import java.util.*;

/**
 * Your implementation of a BST.
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
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize an empty BST.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public BST() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Constructs a new BST.
     *
     * This constructor should initialize the BST with the data in the
     * Collection. The data should be added in the same order it is in the
     * Collection.
     *
     * Hint: Not all Collections are indexable like Lists, so a regular for loop
     * will not work here. However, all Collections are Iterable, so what type
     * of loop would work?
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data or any element in data
     *                                            is null
     */
    public BST(Collection<T> data) {
        if (data == null || data.contains(null)) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else {
            for (T element : data) {
                this.add(element);
            }
        }

    }

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The data becomes a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to add
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else {
            if (this.size == 0) {
                this.root = new BSTNode<>(data);
                this.size++;
            } else {
                addHelper(data, this.root);
            }
        }
    }
    /**
     * Adds the data to the tree.
     * This is the helper method for add, it adds the data recursively
     * Must be O(log n) for best and average cases and O(n) for worst case.
     * @param data the data to add
     * @param node the current node that the is being checked in the BST
     */

    private void addHelper(T data, BSTNode<T> node) {
        BSTNode<T> copy = new BSTNode<>(data);
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(copy);
                this.size++;
            } else {
                addHelper(data, node.getLeft());
            }

        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRight() == null) {
                node.setRight(copy);
                this.size++;
            } else {
                addHelper(data, node.getRight());
            }

        }

    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     * replace the data. You MUST use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to remove
     * @return the data that was removed
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T remove(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        BSTNode<T> dummyNode = new BSTNode<T>(null);
        this.root = removeHelper(data, this.root, dummyNode);
        return dummyNode.getData();
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     *
     * @param data the data to remove
     * @param node the current node the BST is on
     * @param dummyNode a placer node for pointer reinforcement
     * @return the data that was removed
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */

    private BSTNode<T> removeHelper(T data, BSTNode<T> node, BSTNode<T> dummyNode) {
        if (node == null) {
            throw new java.util.NoSuchElementException("data not found");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(removeHelper(data, node.getLeft(), dummyNode));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(removeHelper(data, node.getRight(), dummyNode));
        } else if (data.equals(node.getData())) {
            dummyNode.setData(node.getData());
            this.size--;
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() != null && node.getRight() == null) {
                return node.getLeft();
            } else if (node.getLeft() == null && node.getRight() != null) {
                return node.getRight();
            } else {
                BSTNode<T> dummyNode2 = new BSTNode<>(null);
                assert node.getRight() != null;
                node.setRight(removeSuccessor(node.getRight(), dummyNode2));
                node.setData(dummyNode2.getData());
            }
        }
        return node;
    }

    /**
     * helper method for remove, using the successor to replace the data.
     *
     *
     * @param node the current node the BST is on
     * @param dummy a placer node for pointer reinforcement
     * @return the data that was removed.
     */

    private BSTNode<T> removeSuccessor(BSTNode<T> node, BSTNode<T> dummy) {
        if (node.getLeft() == null) {
            dummy.setData(node.getData());
            return node.getRight();
        } else {
            node.setLeft(removeSuccessor(node.getLeft(), dummy));
        }
        return node;
    }


    /**
     * Returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return the data in the tree equal to the parameter
     * @throws java.lang.IllegalArgumentException if data is null
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else if (this.size == 0) {
            throw new java.util.NoSuchElementException("data not found");
        } else {
            return (getHelper(data, this.root));
        }

    }

    /**
     * Returns the node from the tree to the get method
     *
     *
     * @param data the data to search for
     * @param node the current node the method is looking at
     * @return the node the data is equal to
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */

    private T getHelper(T data, BSTNode<T> node) {
        if (node.getData() == null) {
            throw new java.util.NoSuchElementException("Data not found");
        }
        if (data.compareTo(node.getData()) < 0) {
            return getHelper(data, node.getLeft());
        } else if (data.compareTo(node.getData()) > 0) {
            return getHelper(data, node.getRight());
        } else {
            return node.getData();
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This must be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return (containsHelper(data, this.root));
    }

    /**
     * Returns the answer if the BST contains the data, helper method for contains
     *
     *
     * @param data the data to search for
     * @param node the current node the method is looking at
     * @return if the data is in the tree or not
     */

    private boolean containsHelper(T data, BSTNode<T> node) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.getData()) < 0) {
            return containsHelper(data, node.getLeft());
        } else if (data.compareTo(node.getData()) > 0) {
            return containsHelper(data, node.getRight());
        } else {
            return data.equals(node.getData());
        }
    }

    /**
     * Generate a pre-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the preorder traversal of the tree
     */
    public List<T> preorder() {
        List<T> list = new ArrayList<>();
        preorderHelper(this.root, list);
        return list;

    }

    /**
     * recursive helper method for preorder
     * @param node the starting node
     * @param list the list that we are returning in preorder
     *
     */

    private void preorderHelper(BSTNode<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            preorderHelper(node.getLeft(), list);
            preorderHelper(node.getRight(), list);
        }
    }

    /**
     * Generate an in-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the inorder traversal of the tree
     */
    public List<T> inorder() {
        List<T> list = new ArrayList<>();
        inorderHelper(this.root, list);
        return list;
    }

    /**
     * helper method for inorder, adds to the list all the data of the BST in inorder
     *
     * @param node the current node the method is looking at
     * @param list the list that we will use in the inorder method
     */

    private void inorderHelper(BSTNode<T> node, List<T> list) {
        if (node != null) {
            inorderHelper(node.getLeft(), list);
            list.add(node.getData());
            inorderHelper(node.getRight(), list);
        }
    }

    /**
     * Generate a post-order traversal of the tree.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @return the postorder traversal of the tree
     */
    public List<T> postorder() {
        List<T> list = new ArrayList<>();
        postorderHelper(this.root, list);
        return list;
    }

    /**
     * helper method for inorder, adds to the list all the data of the BST in postorder
     *
     * @param node the current node the method is looking at
     * @param list the list that we will use in the postorder method
     */

    private void postorderHelper(BSTNode<T> node, List<T> list) {
        if (node != null) {
            postorderHelper(node.getLeft(), list);
            postorderHelper(node.getRight(), list);
            list.add(node.getData());
        }
    }


    /**
     * Generate a level-order traversal of the tree.
     *
     * This does not need to be done recursively.
     *
     * Hint: You will need to use a queue of nodes. Think about what initial
     * node you should add to the queue and what loop / loop conditions you
     * should use.
     *
     * Must be O(n).
     *
     * @return the level order traversal of the tree
     */
    public List<T> levelorder() {
        List<T> list = new ArrayList<>();
        Queue<BSTNode<T>> q = new LinkedList<>();
        q.add(this.root);
        while (!(q.isEmpty())) {
            BSTNode<T> node = q.poll();
            list.add(node.getData());
            if (node.getLeft() != null) {
                q.add(node.getLeft());
            }
            if (node.getRight() != null) {
                q.add(node.getRight());
            }
        }
        return list;
    }

    /**
     * Returns the height of the root of the tree.
     *
     * This must be done recursively.
     *
     * A node's height is defined as max(left.height, right.height) + 1. A
     * leaf node has a height of 0 and a null child has a height of -1.
     *
     * Must be O(n).
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        if (this.size == 0) {
            return -1;
        } else {
            int number = 0;
            Queue<BSTNode<T>> q = new LinkedList<>();
            q.add(this.root);
            while (!(q.isEmpty())) {
                BSTNode<T> node = q.poll();
                number++;
                if (node.getLeft() != null) {
                    q.add(node.getLeft());

                } else if (node.getRight() != null) {
                    q.add(node.getRight());
                }
            }
            return number - 1;
        }

    }

    /**
     * Clears the tree.
     *
     * Clears all data and resets the size.
     *
     * Must be O(1).
     */
    public void clear() {
        this.root = null;
        this.size = 0;

    }

    /**
     * Finds and retrieves the k-largest elements from the BST in sorted order,
     * least to greatest.
     *
     * This must be done recursively.
     *
     * In most cases, this method will not need to traverse the entire tree to
     * function properly, so you should only traverse the branches of the tree
     * necessary to get the data and only do so once. Failure to do so will
     * result in an efficiency penalty.
     *
     * EXAMPLE: Given the BST below composed of Integers:
     *
     *                50
     *              /    \
     *            25      75
     *           /  \
     *          12   37
     *         /  \    \
     *        10  15    40
     *           /
     *          13
     *
     * kLargest(5) should return the list [25, 37, 40, 50, 75].
     * kLargest(3) should return the list [40, 50, 75].
     *
     * Should have a running time of O(log(n) + k) for a balanced tree and a
     * worst case of O(n + k).
     *
     * @param k the number of largest elements to return
     * @return sorted list consisting of the k largest elements
     * @throws java.lang.IllegalArgumentException if k > n, the number of data
     *                                            in the BST
     */
    public List<T> kLargest(int k) {
        if (k > this.size) {
            throw new java.lang.IllegalArgumentException("Not enough data in the BST");
        } else {
            List<T> list = new ArrayList<>();
            kLargestHelper(this.root, list, k);
            return reverseList(list);

        }
    }

    /**
     * helper method for klargest, adds to the list all the data of the BST in from largest to smallest
     *
     * @param node the current node the method is looking at
     * @param list the list that we are updating
     * @param totalSize the size of the list

     */

    private void kLargestHelper(BSTNode<T> node, List<T> list, int totalSize) {
        if (node != null && list.size() < totalSize) {
            kLargestHelper(node.getRight(), list, totalSize);

            if (list.size() < totalSize) {
                list.add(node.getData());
            }
            if (list.size() < totalSize) {
                kLargestHelper(node.getLeft(), list, totalSize);
            }

        }
    }

    /**
     * helper method for klargest, reverses the list in smallest to largest order
     *
     * @param list the list that we are updating
     * @return reversedList the list that is in sorted order
     */

    private List<T> reverseList(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<T> reversedList = new ArrayList<>();
        reversedList.add(list.get(list.size() - 1));
        reversedList.addAll(reverseList(list.subList(0, list.size() - 1)));
        return reversedList;

    }




    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}